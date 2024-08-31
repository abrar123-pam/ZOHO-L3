
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
class Booking{
	
	private static final String DATA_FILE = "C:\\Users\\inc5540-37\\Desktop\\L3\\Railway Reservation Zylker\\data.txt";

    static int availableLowerBerth = 1;
    static int availableMiddleBerth = 1;
    static int availableUpperBerth = 1;
    static int availableRACtickets = 1;
    static int availableWaitingList = 1;

    static List<Integer> LBcount = new ArrayList<>(Arrays.asList(1,2));
    static List<Integer> MBcount = new ArrayList<>(Arrays.asList(1));
    static List<Integer> UBcount = new ArrayList<>(Arrays.asList(1));
    static List<Integer> RACcount = new ArrayList<>(Arrays.asList(1,2));
    static List<Integer> WLcount = new ArrayList<>(Arrays.asList(1,2));

    static List<String> bookedTicket = new ArrayList<>();
    static Map<String, List<Passenger>> stored_data = new HashMap<>();
    static Queue<String> racTicket = new LinkedList<>();
    static Queue<String> wt = new LinkedList<>();
	
	
	public static void saveData(){
		try(FileWriter writer = new FileWriter(DATA_FILE)){
			for (List<Passenger> passengers : stored_data.values()) {
				for (Passenger pass : passengers) {
					writer.write(pass.toString() + "\n");
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void loadData(){
    try(BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))){
         String line;
         while((line = reader.readLine()) != null){
             Passenger p = Passenger.fromString(line);
             String pnr = p.pnr; 
             if (stored_data.containsKey(pnr)) {
                 stored_data.get(pnr).add(p);
             } else {
                 List<Passenger> passengers = new ArrayList<>();
                 passengers.add(p);
                 stored_data.put(pnr, passengers);
             }
         }
    } catch(IOException e){
        e.printStackTrace();
    }
}

	

    public void bookTicket(String pnr,Passenger p, int seatNo, String allotted){
        p.seatNumber = seatNo;
        p.allotted = allotted;
        p.bookingStatus = "CNF";
        p.currentStatus = "CNF";
        if (stored_data.containsKey(pnr)) {
            stored_data.get(pnr).add(p);
        } else {
            List<Passenger> passengers = new ArrayList<>();
            passengers.add(p);
            stored_data.put(pnr, passengers);
        }
        bookedTicket.add(pnr);

        System.out.println("PNR number : "+pnr);
        System.out.println("Name : "+p.name);
        System.out.println("Age : "+p.age);
        System.out.println("Seat Number : "+p.seatNumber+" "+p.allotted);
        System.out.println("-------------------------Booked Successfully");
    }

    public void bookRacTicket(String pnr, Passenger p, int seatNo, String allotted){
        p.seatNumber = seatNo;
        p.allotted = allotted;
        p.bookingStatus = "RAC";
        p.currentStatus = "RAC";
        if (stored_data.containsKey(pnr)) {
            stored_data.get(pnr).add(p);
        } else {
            List<Passenger> passengers = new ArrayList<>();
            passengers.add(p);
            stored_data.put(pnr, passengers);
        }
        racTicket.add(pnr);
        System.out.println("PNR number : "+pnr);
        System.out.println("Name : "+p.name);
        System.out.println("Age : "+p.age);
        System.out.println("Seat Number : "+p.seatNumber+" "+p.allotted);
        System.out.println("-------------------------RAC Given");
    }

    public void waitingTicket(String pnr, Passenger p, int seatNo, String allotted){
        p.seatNumber = seatNo;
        p.allotted = allotted;
        p.bookingStatus = "WL";
        p.currentStatus = "WL";
        if (stored_data.containsKey(pnr)) {
            stored_data.get(pnr).add(p);
        } else {
            List<Passenger> passengers = new ArrayList<>();
            passengers.add(p);
            stored_data.put(pnr, passengers);
        }
        wt.add(pnr);

        System.out.println("PNR number : "+pnr);
        System.out.println("Name : "+p.name);
        System.out.println("Age : "+p.age);
        System.out.println("Seat Number : "+p.seatNumber+" "+p.allotted);
        System.out.println("-------------------------WaitListed");
    }

    public void displaypnr(int n) {

        String pnr = String.valueOf(n);
        if (!stored_data.containsKey(pnr)) {
            System.out.println("No data found for this PNR: " + pnr);
            return;
        }

        System.out.println("PNR - " + pnr);
        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("S NO                Name                Age                 Booking status      Current status      Berth");

        List<Passenger> passengers = stored_data.get(pnr);
        int id = 1;
        for (Passenger p : passengers) {
            System.out.printf("%-20d%-20s%-20d%-20s%-20s%-20s\n", id++, p.name, p.age, p.bookingStatus, p.currentStatus, p.seatNumber + "/" + p.allotted);
        }


        System.out.println("------------------------------------------------------------------------------------");
    }

    public void cancelTicket(String pnr, List<Integer> serials) {
        List<Passenger> passengers = stored_data.get(pnr);
        List<Passenger> remainingPassengers = new ArrayList<>();
        for (int i = 0; i < passengers.size(); i++) {
            Passenger p = passengers.get(i);
            if (serials.contains(i + 1)) {
                switch (p.allotted) {
                    case "L":
                        availableLowerBerth++;
                        LBcount.add(p.seatNumber);
                        break;
                    case "M":
                        availableMiddleBerth++;
                        MBcount.add(p.seatNumber);
                        break;
                    case "U":
                        availableUpperBerth++;
                        UBcount.add(p.seatNumber);
                        break;
                }
                System.out.println("Cancelled ticket for: " + p.name);

                if (!racTicket.isEmpty()) {
                    String racPnr = racTicket.poll();
                    List<Passenger> racPassengers = stored_data.get(racPnr);
                    Passenger racPassenger = racPassengers.get(0);
                    racPassenger.allotted = p.allotted;
                    racPassenger.currentStatus = "CNF";
                    racPassenger.bookingStatus = "RAC";

                    switch (p.allotted) {
                        case "L":
                            racPassenger.seatNumber = LBcount.remove(0);
                            availableLowerBerth--;
                            break;
                        case "M":
                            racPassenger.seatNumber = MBcount.remove(0);
                            availableMiddleBerth--;
                            break;
                        case "U":
                            racPassenger.seatNumber = UBcount.remove(0);
                            availableUpperBerth--;
                            break;
                    }

                    System.out.println("RAC passenger " + racPassenger.name + " moved to confirmed berth");
                }

                // Move WL to RAC berth
                if (!wt.isEmpty()) {
                    String wlPnr = wt.poll();
                    List<Passenger> wlPassengers = stored_data.get(wlPnr);
                    Passenger wlPassenger = wlPassengers.get(0);
                    wlPassenger.allotted = "RAC";
                    wlPassenger.currentStatus = "RAC";
                    wlPassenger.bookingStatus = "WL";
                    wlPassenger.seatNumber = RACcount.remove(0);
                    availableRACtickets--;

                    System.out.println("Waitlisted passenger " + wlPassenger.name + " moved to RAC berth");
                }
            } else {
                remainingPassengers.add(p);
            }
        }
        if (remainingPassengers.isEmpty()) {
            stored_data.remove(pnr);
            bookedTicket.remove(pnr);
        } else {
            stored_data.put(pnr, remainingPassengers);
        }
    }

/*
 public void cancel(int pnrNumber, int serialNum) {
        String pnr = String.valueOf(pnrNumber);
        List<Passenger> passengers = stored_data.get(pnr);
        if (passengers == null || passengers.size() < serialNum) {
            System.out.println("Passenger not found.");
            return;
        }

        Passenger p = passengers.get(serialNum - 1);
        stored_data.remove(pnr);
        bookedTicket.remove(pnr);

        int sNumber = p.seatNumber;
        System.out.println("Cancelled Successfully");
        if (p.allotted.equals("L")) {
            LBcount.add(sNumber);
            availableLowerBerth++;
        } else if (p.allotted.equals("M")) {
            MBcount.add(sNumber);
            availableMiddleBerth++;
        } else if (p.allotted.equals("U")) {
            UBcount.add(sNumber);
            availableUpperBerth++;
        } else if (p.allotted.equals("RAC")) {
            RACcount.add(sNumber);
            availableRACtickets++;
        } else if (p.allotted.equals("WL")) {
            WLcount.add(sNumber);
            availableWaitingList++;
        }

        if (availableRACtickets > 0 && WLcount.size() > 0) {
            Passenger wlPassenger = stored_data.get(String.valueOf(WLcount.get(0))).get(0);
            WLcount.remove(0);
            availableWaitingList--;

            wlPassenger.bookingStatus = "RAC";
            wlPassenger.currentStatus = "RAC";
            wlPassenger.allotted = "RAC";
            RACcount.remove(0);
            availableRACtickets--;

            stored_data.put(wlPassenger.pnr, new ArrayList<>(Arrays.asList(wlPassenger)));
            System.out.println("RAC ticket given to WL passenger: " + wlPassenger.name);
        }

        if (availableLowerBerth > 0 || availableMiddleBerth > 0 || availableUpperBerth > 0) {
            Passenger racPassenger = stored_data.get(String.valueOf(RACcount.get(0))).get(0);
            RACcount.remove(0);
            availableRACtickets++;

            if (availableLowerBerth > 0) {
                System.out.println("Lower Berth Given to RAC passenger");
                bookTicket(racPassenger.pnr, racPassenger, LBcount.get(0), "L");
                LBcount.remove(0);
                availableLowerBerth--;
            } else if (availableMiddleBerth > 0) {
                System.out.println("Middle berth Given to RAC passenger");
                bookTicket(racPassenger.pnr, racPassenger, MBcount.get(0), "M");
                MBcount.remove(0);
                availableMiddleBerth--;
            } else if (availableUpperBerth > 0) {
                System.out.println("Upper berth Given to RAC passenger");
                bookTicket(racPassenger.pnr, racPassenger, UBcount.get(0), "U");
                UBcount.remove(0);
                availableUpperBerth--;
            }
        }
    }
 */


}
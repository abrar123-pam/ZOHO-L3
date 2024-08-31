
import java.util.*;

class Zylker_Railways{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		
		loadData();
        boolean loop = true;
        Booking b = new Booking();
        while(loop){
            System.out.println("1. Book\n2. Cancel\n3. Display PNR\n4. Display Chart\n5. Available seats\n6. Exit");
            int choice  = sc.nextInt();

            switch(choice){
                case 1:
                    bookTickets(sc,b);
                    break;

                case 2:
                    cancelTicket(sc,b);
                    break;
                case 3:
                    DisplayPNR(sc,b);
                    break;
                case 4:
					displayChart(b);
                    break;
                case 5:
                    displayAvailability();
                    break;
                case 6:
                    loop = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
			saveData();
        }
    }
	
	public static void loadData(){
		Booking.loadData();
	}
	public static void saveData(){
		Booking.saveData();
	}
	
	public static void displayChart(Booking b) {
		System.out.println("----------------------------------------------------");
		System.out.println("PNR\tBerth No\tCurrent Status\tBerth Type\tName\tAge");
		System.out.println("----------------------------------------------------");

		for (String pnr : Booking.stored_data.keySet()) {
			List<Passenger> passengers = Booking.stored_data.get(pnr);
			for (Passenger p : passengers) {
				String berthType = "";
				switch (p.allotted) {
					case "L":
						berthType = "Lower";
						break;
					case "M":
						berthType = "Middle";
						break;
					case "U":
						berthType = "Upper";
						break;
					default:
						berthType = "N/A";
						break;
				}
				System.out.printf("%s\t%d\t\t%s\t\t%s\t\t%s\t%d\n", pnr, p.seatNumber, p.currentStatus, berthType, p.name, p.age);
			}
		}

		System.out.println("----------------------------------------------------");
	}


    public static void bookTickets(Scanner sc,Booking b){
        Random random = new Random();
        int nr = random.nextInt(900000) + 100000;
        String pnr = String.valueOf(nr);

        System.out.println("Enter number of passengers: ");
        int numPassengers = sc.nextInt();
        List<Passenger> passengers = new ArrayList<>();

        for (int i = 1; i <= numPassengers; i++) {
            System.out.println("Enter details for Passenger " + i);
            System.out.println("Enter name : ");
            String name = sc.next();
            System.out.println("Enter age : ");
            int age = sc.nextInt();
            System.out.println("Is this passenger a child? (true/false): ");
            boolean isChild = sc.nextBoolean();
            System.out.println("Enter Berth Preference (L/M/U/-): ");
            String bp = sc.next();
            Passenger p = new Passenger(name, age, bp, pnr, isChild);
            passengers.add(p);
        }

        boolean groupFlag = true;
        for (Passenger passenger : passengers) {
            if (passenger.isChild && !passenger.berth.equals("L")) {
                if (Booking.availableLowerBerth > 0) {
                    passenger.berth = "L";
                } else {
                    groupFlag = false;
                    break;
                }
            }
        }

        if (groupFlag) {
            for (Passenger passenger : passengers) {
                BookTicket(pnr, passenger,b);
            }
        } else {
            System.out.println("Lower berth not available for passengers traveling with kids. Booking aborted.");
        }
	/*	System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter age : ");
		int age = sc.nextInt();
		System.out.println("Enter Berth Preferece");
		String bp = sc.next();
		boolean flag = false;
		if(bp.equals("L")){
			if(Booking.availableLowerBerth > 0){
				flag = true;
			}
		}else if(bp.equals("M")){
			if(Booking.availableMiddleBerth > 0){
				flag = true;
			}
		}else if(bp.equals("U")){
			if(Booking.availableUpperBerth > 0){
				flag = true;
			}
		}else if(bp.equals("-")){
			flag = true;
		}

		if(flag){
			Passenger p = new Passenger(name,age,bp,pnr);
			BookTicket(pnr,p,sc,b);
		}else{
			System.out.println("The "+ bp+" is not available Right now");
			System.out.println("Are you okay with any other berth [Y/N]");
			String check = sc.next();
			if(check.equals("Y") || check.equals("N")){
				Passenger p = new Passenger(name,age,bp,pnr);
				BookTicket(pnr,p,sc,b);
			}
		} */
    }

    public static void BookTicket(String pnr,Passenger p,Booking b){

        if(Booking.availableWaitingList == 0){
            System.out.println("No more tickets Availabe");
            return;
        }
        else if(p.age > 60 && Booking.availableLowerBerth > 0){
            System.out.println("You are Senior Citizen so we have provided you Lower Berth");
            b.bookTicket(pnr,p,Booking.LBcount.get(0),"L");
            Booking.LBcount.remove(0);
            Booking.availableLowerBerth--;
        }

        else if((p.berth.equals("L") && Booking.availableLowerBerth > 0) ||
                (p.berth.equals("M") && Booking.availableMiddleBerth > 0) ||
                (p.berth.equals("U") && Booking.availableUpperBerth > 0)){
            if(p.berth.equals("L") && Booking.availableLowerBerth > 0){
                System.out.println("Lower Berth Given");
                b.bookTicket(pnr,p,Booking.LBcount.get(0),"L");
                Booking.LBcount.remove(0);
                Booking.availableLowerBerth--;
            }else if(p.berth.equals("M") && Booking.availableMiddleBerth > 0){
                System.out.println("Middle berth Given");
                b.bookTicket(pnr,p,Booking.MBcount.get(0),"M");
                Booking.MBcount.remove(0);
                Booking.availableMiddleBerth--;
            }else if(p.berth.equals("U") && Booking.availableUpperBerth > 0){
                System.out.println("Upper berth Given");
                b.bookTicket(pnr,p,Booking.UBcount.get(0),"U");
                Booking.UBcount.remove(0);
                Booking.availableUpperBerth--;
            }
        }
        else if(Booking.availableLowerBerth > 0){
            System.out.println("Lower Berth Given");
            b.bookTicket(pnr,p,Booking.LBcount.get(0),"L");
            Booking.LBcount.remove(0);
            Booking.availableLowerBerth--;
        }else if(Booking.availableMiddleBerth > 0){
            System.out.println("Middle berth Given");
            b.bookTicket(pnr,p,Booking.MBcount.get(0),"M");
            Booking.MBcount.remove(0);
            Booking.availableMiddleBerth--;
        }else if(Booking.availableUpperBerth > 0){
            System.out.println("Upper berth Given");
            b.bookTicket(pnr,p,Booking.UBcount.get(0),"U");
            Booking.UBcount.remove(0);
            Booking.availableUpperBerth--;
        }else if(Booking.availableRACtickets > 0){
            System.out.println("RAC ticket given");
            b.bookRacTicket(pnr,p,Booking.RACcount.get(0),"RAC");
            Booking.RACcount.remove(0);
            Booking.availableRACtickets--;
        }else if(Booking.availableWaitingList > 0){

            b.waitingTicket(pnr,p,Booking.WLcount.get(0),"WL");
            Booking.WLcount.remove(0);
            Booking.availableWaitingList--;
        }

    }

    public static void DisplayPNR(Scanner sc, Booking b){

        System.out.println("Enter PNR number : ");
        int n = sc.nextInt();

        b.displaypnr(n);
    }

    public static void cancelTicket(Scanner sc, Booking b){
        System.out.println("Enter PNR number : ");
        String pnr = sc.next();

        if(!Booking.stored_data.containsKey(pnr)){
            System.out.println("No data found for this PNR: " + pnr);
            return;
        }

        b.displaypnr(Integer.parseInt(pnr));

        System.out.println("Enter the serial numbers of passengers to cancel (comma-separated): ");

        String[] serialNumbers = sc.next().split(",");
        List<Integer> serials = new ArrayList<>();

        for (String s : serialNumbers) {
            serials.add(Integer.parseInt(s.trim()));
        }

        b.cancelTicket(pnr, serials);

        if (!Booking.stored_data.containsKey(pnr)) {
            System.out.println("All tickets under PNR " + pnr + " have been cancelled.");
        } else {
            b.displaypnr(Integer.parseInt(pnr));
        }


    }

    public static void displayAvailability() {
        System.out.println("Available Lower Berths: " + Booking.availableLowerBerth);
        System.out.println("Available Middle Berths: " + Booking.availableMiddleBerth);
        System.out.println("Available Upper Berths: " + Booking.availableUpperBerth);
        System.out.println("Available RAC tickets: " + Booking.availableRACtickets);
        System.out.println("Available Waiting List: " + Booking.availableWaitingList);
    }
}
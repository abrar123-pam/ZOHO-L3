import java.util.*;


public class Booking	{
	
	static int availableUpperBerth = 2;
	static int availableLowerBerth = 1;
	static int availableMiddleBerth = 1;
	static int availableWaitingList = 1;
	
	
	static List<Integer> bookedTicket = new ArrayList<>();
	static List<Integer> LbCount = new ArrayList<>(Arrays.asList(1,2));
	static List<Integer> UbCount = new ArrayList<>(Arrays.asList(1));
	static List<Integer> MbCount = new ArrayList<>(Arrays.asList(1));
	static List<Integer> WlCount = new ArrayList<>(Arrays.asList(1));
	
	
	static Map<Integer,PassengerDetails> map = new HashMap<>();
	
	
	public void prepareChart() {
		System.out.println("--------------------------------------------");
		System.out.println("     TRAIN NAME : Yelagiri Express");
		System.out.println("        TRAIN NUMBER : 146342");
		System.out.println("--------------------------------------------");
		System.out.println("NAME          AGE     GENDER     PREFERENCE");
		for (PassengerDetails b : map.values()) {
			String formattedName = String.format("%-15s", b.getName());
			String formattedAge = String.format("%-8d", b.getAge());
			String formattedGender = String.format("%-10s", b.getGender());
			String formattedBerth = String.format("%-10s", b.getBerth());
			System.out.println(formattedName + formattedAge + formattedGender + b.getSeatNumber()+formattedBerth);
		}
}

	
	
    public void bookTickets(PassengerDetails p,int seatNumber,String berth){
        p.allotted = berth;
        p.seatNumber = seatNumber;
        map.put(p.passengerId,p);
        bookedTicket.add(p.passengerId);

        System.out.println("Passenger ID : "+p.passengerId);
        System.out.println("Name : "+p.name);
        System.out.println("Age : "+p.age);
        System.out.println("Gender : "+p.gender);
        System.out.println("Seat Number : "+p.seatNumber+" "+p.allotted);
        System.out.println("-------------------------Booked Successfully");
    }
	
	public void cancel(int pid){
		
		PassengerDetails p = map.get(pid);
		
		bookedTicket.remove(pid);
		map.remove(pid);
		
		int seatNumber = p.getSeatNumber();
		System.out.println("Cancelled Successfully");
        if(p.allotted.equals("L")){
            LbCount.add(seatNumber);
            availableLowerBerth++;
        }else if(p.allotted.equals("M")){
            MbCount.add(seatNumber);
            availableMiddleBerth++;
        } else if (p.allotted.equals("U")) {
            UbCount.add(seatNumber);
            availableUpperBerth++;
        }else if(p.allotted.equals("W")){
			WlCount.add(seatNumber);
			availableWaitingList++;
		}
		
	}
	

	

}

import java.util.*;

public class RailwayReservationSystem{

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		
		
		
		while(loop){
			
			System.out.println("\n1. Book\n2. Check Availability\n3. Prepare chart\n4. Cancel\n5. Exit");
			System.out.print("Enter your choice : ");
		
			int choice = sc.nextInt();
			switch(choice){
			case 1:
				System.out.println("Enter your name : ");
				String name = sc.next();
				System.out.println("Enter your age : ");
				int age = sc.nextInt();
				System.out.println("Enter your gender : [M|F]");
				String gender = sc.next();
				System.out.println("Enter your berth preference : ");
				String preference = sc.next();
				PassengerDetails book = new PassengerDetails(name,age,gender,preference);
				
				bookTicket(book);
				
				break;
				
			case 2:
				
				showAwailableTickets();
			
				break;
			
			case 3:
				Booking booking = new Booking();
				booking.prepareChart();
				break;
				
			case 4:
				System.out.print("Enter your passengerID : ");
				int pid = sc.nextInt();
				cancel(pid);
				break;
				
			case 5:
				System.out.print("Exitting...........");
				loop = false;
				break;
				
			default:
				System.out.println("Enter valid number");
				break;
				
			}
		}
	}
	
	public static void cancel(int pid){
		
		Booking b = new Booking();
		if(!Booking.map.containsKey(pid)){
			System.out.println("No details Found");
		}else{
			
			b.cancel(pid);
		}
	}
	
	
	public static void showAwailableTickets(){
		System.out.println("---------------------------------------");
		System.out.println("Available Tickets");
		System.out.println("Available Upper Berth Tickets : "+Booking.availableUpperBerth);
		System.out.println("Available Middle Berth Tickets : "+Booking.availableMiddleBerth);
		System.out.println("Available Lower Berth Tickets : "+Booking.availableLowerBerth);
		System.out.println("Available Waiting List Tickets : "+Booking.availableWaitingList);
		System.out.println("---------------------------------------");		
	}
	
	public static void bookTicket(PassengerDetails p){
		Booking b = new Booking();
		
		if(Booking.availableWaitingList == 0){
			
			System.out.println("No more tickets available");
			return;
		}else if(p.berth.equals("L") && b.availableLowerBerth > 0){
			System.out.println("Lower Berth Given");
			b.bookTickets(p,Booking.LbCount.get(0),"L");
			Booking.LbCount.remove(0);
			Booking.availableLowerBerth--;
		}else if(p.berth.equals("M") && b.availableMiddleBerth > 0){
			System.out.println("Middle Berth Given");
			b.bookTickets(p,Booking.MbCount.get(0),"M");
			Booking.MbCount.remove(0);
			Booking.availableMiddleBerth--;
		}else if(p.berth.equals("U") && b.availableUpperBerth > 0){
			System.out.println("Upper Berth Given");
			b.bookTickets(p,Booking.UbCount.get(0),"U");
			Booking.UbCount.remove(0);
			Booking.availableUpperBerth--;
		}else{
			System.out.println("Your Ticket is waitlisted");
			b.bookTickets(p,Booking.WlCount.get(0),"WL");
			Booking.WlCount.remove(0);
			Booking.availableWaitingList--;
		}
	}
	

	
	

}
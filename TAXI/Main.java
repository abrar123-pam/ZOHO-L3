import java.util.*;


class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		List<Taxi> taxis = createTaxi(4);
		int id = 1;
		
		while(loop){
			System.out.println("1. Call taxi booking\n2. Display the Taxi details\n3. Exit");
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("Enter Pick_up point : ");
					char p_point = sc.next().charAt(0);
					System.out.println("Enter Drop point : ");
					char d_point = sc.next().charAt(0);
					System.out.println("Enter pick up time : ");
					int p_time = sc.nextInt();
					
					
					if(p_point <'A'||p_point > 'F' || d_point <'A' || d_point > 'F'){
						System.out.println("The valid Taxi Stations are     [A,B,C,D,E,F]");
						break;
					}
					
					List<Taxi> f_taxi = getFreeTaxies(taxis,p_time,p_point);
					if(f_taxi.size() == 0){
						System.out.println("No Taxi Available At this time ");
						break;
					}
					
					bookTaxi(id,p_point,d_point,p_time,f_taxi);
					id++;
					break;
				case 2:
					for(Taxi t : taxis){
						t.printTaxiDetails();
					}
					for(Taxi t : taxis){
						t.printDetails();
					}
					break;
				case 3:
					System.out.println("--------EXITTING-------");
					loop = false;
					break;
				default:
					System.out.println("Enter Valid Choice");
					break;
			}
		}
	}
	
	public static void bookTaxi(int id, char p_point,char d_point,int p_time,List<Taxi> f_taxi){
    int minDistance = Integer.MAX_VALUE;
    int minEarnings = Integer.MAX_VALUE;
    int distanceBetweenpickUpandDrop = 0;
    int earning = 0;
    int nextFreeTime = 0;
    char nextSpot = 'Z';
    Taxi bookedTaxi = null;
    String tripDetail = "";
    
    for(Taxi t: f_taxi){
        int distanceBetweenCustomerAndTaxi = Math.abs((t.currSpot - '0') - (p_point - '0')) * 15;
        int earnings = t.totalEarnings;
		//distanceBetweenCustomerAndTaxi < minDistance
       
        if(earnings < minEarnings || (earnings == minEarnings && distanceBetweenCustomerAndTaxi < minDistance)  ){
            bookedTaxi = t;
            minDistance = distanceBetweenCustomerAndTaxi;
            minEarnings = earnings;
            
            distanceBetweenpickUpandDrop = Math.abs((d_point - '0') - (p_point-'0')) * 15;
            earning = (distanceBetweenpickUpandDrop-5)*10+100;
            
            int dropTime = p_time + distanceBetweenpickUpandDrop / 15;
            
            nextFreeTime = dropTime;
            nextSpot = d_point;
            tripDetail = id+"          "+id+"          "+p_point+"          "+d_point+"          "+p_time+"          "+dropTime+"          "+earning;
        }
    }
    
    if(bookedTaxi != null){
        bookedTaxi.setDetails(nextSpot,bookedTaxi.totalEarnings+earning,nextFreeTime,tripDetail);
        System.out.println("Taxi "+bookedTaxi.id+" booked");
    } else {
        System.out.println("No suitable taxi available for booking.");
    }
}

	
	
	public static List<Taxi> getFreeTaxies(List<Taxi> taxis, int p_time, char p_point){
		List<Taxi> freeTaxi = new ArrayList<>();
		
		for(Taxi t:taxis){
			
			if(t.freeTime <= p_time && Math.abs(t.currSpot - '0') - (p_point - '0') <= (p_point-'0')){
				freeTaxi.add(t);
			}
			
		}
		return freeTaxi;
	}
	
	public static List<Taxi> createTaxi(int n){
		List<Taxi> taxis = new ArrayList<>();
		
		for(int i=0;i<n;i++){
			taxis.add(new Taxi());
		}
		return taxis;
	}
}
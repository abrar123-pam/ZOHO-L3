import java.util.*;

class Parking{
	
	static Map<String,Car> car_map = new HashMap<>();
	static Map<String,Bike> bike_map = new HashMap<>();
	static Scanner sc = new Scanner(System.in);
	
	static char[][] arr = new char[26][5];
	

	public void addNewCar(String number, Car car){
		car_map.put(number,car);
	}
	
	public void addNewBike(String number, Bike bike){
		bike_map.put(number,bike);
	}
	public void exitCar(String carNum){
		if(!car_map.containsKey(carNum)){
			System.out.println("No car is there with this number "+ carNum);
		} else {
			Car car = car_map.get(carNum);
			System.out.println("Your Entry time is : "+car.getEntryTime());
			System.out.println("Enter Exit time : ");
			double exit = sc.nextDouble();
			calculateAmount(car.getEntryTime(), exit);
		}
	}
	
	public static void calculateAmount(double entry, double exit){
    final double hour = 50.00;
    double ans = exit - entry;
    double fi = ans * hour;
    System.out.printf("Your total Amount is : %.2f%n", fi); 
}

	

	
	public void exitBike(String carNum){
		
		if(!bike_map.containsKey(carNum)){
			System.out.println("No car is there with this number "+ carNum);
		}else{
			
			Bike bike = bike_map.get(carNum);
			
			System.out.println("Your Entry time is : "+bike.getEntryTime());
			System.out.println("Enter Exit time : ");
			double exit = sc.nextDouble();
			
			calculateAmountBike(bike.getEntryTime(),exit);
		}
	}
	
	public static void calculateAmountBike(double entry, double exit){
		
		double hour = 10.00;
		double ans = exit - entry;
		
		System.out.println("Your total Amount is : "+ (ans*hour));
	}
	
	public static void findCar(String num){
		if(!car_map.containsKey(num)){
			System.out.println("No car is there with this number "+ num);
		}else{
			Car car = car_map.get(num);
			System.out.println("Your Car is parked in : D slot");
			System.out.println("Your Entry time is : "+car.getEntryTime());
			
		}
		
		
	}
	
	public static void findBike(String num){
		if(!bike_map.containsKey(num)){
			System.out.println("No car is there with this number "+ num);
		}else{
			Bike bike = bike_map.get(num);
			System.out.println("Your Car is parked in : D slot");
			System.out.println("Your Entry time is : "+bike.getEntryTime());
			
		}
		
		
	}
}
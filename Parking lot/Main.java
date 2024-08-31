import java.util.*;
import java.util.regex.*;  


class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Parking parking = new Parking();
		boolean loop = true;
		
		while(loop){
			System.out.println("1.Car\n2. Two Wheeler\n3. Exit Vehical\n4. Find Vehical\n5. End");
			
			int choice = sc.nextInt();
			
			switch(choice){
				case 1:
					parkCar(sc,parking);
					break;
				case 2:
					parkBike(sc,parking);
					break;
				case 3:
					exitVehical(sc,parking);
					break;
				case 4:
					findVehical(sc,parking);
					break;
				case 5:
					loop = false;
					break;
				default:
					break;
			}
		}
	}
	
	public static boolean matchPattern(String s){
		String regex
            = "^[A-Z]{2}[\\ -]{0,1}[0-9]{2}[\\ -]{0,1}[A-Z]{1,2}[\\ -]{0,1}[0-9]{4}$";
        Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		return m.matches();
	}
	public static void parkCar(Scanner sc,Parking p){
		
		System.out.println("Enter vehical No");
		String v_no = sc.next();
		
		if(matchPattern(v_no)){
			System.out.println("Enter entry time");
			double time = sc.nextDouble();
			
			Car car = new Car(v_no,time);
			p.addNewCar(v_no,car);		
		}else{
			System.out.println("enter valid number as [ Example : TN-23-AW2994 ]");
		}
					
		
		
	}
	
	public static void parkBike(Scanner sc,Parking p){
		
		System.out.println("Enter Bike No");
		String b_no = sc.next();
		
		System.out.println("Enter entry time");
		double b_time = sc.nextDouble();
		
		Bike bike = new Bike(b_no,b_time);
		p.addNewBike(b_no,bike);
	}
	
	public static void exitVehical(Scanner sc, Parking p){
		boolean carExit = true;
		
		while(carExit){
			System.out.println("1. car\n2. Two wheeler\n 3. Exit");
		
			int c = sc.nextInt();
			
			switch(c){

				case 1:
					System.out.println("Enter car Number");
					String carNu = sc.next();
					p.exitCar(carNu);
					
					break;
				case 2:
					System.out.println("Enter bike Number");
					String bikeNU = sc.next();
					p.exitBike(bikeNU);
					break;
				case 3:
				carExit = false;
					break;
				default:
				System.out.println("Enter valid choice");
					break;
			}
			
		}
	}
	
	public static void findVehical(Scanner sc, Parking p){
		boolean vehfind = true;
		
		while(vehfind){
			System.out.println("1. car\n2. Two wheeler\n3. Exit");
		
			int c = sc.nextInt();
			
			switch(c){

				case 1:
					System.out.println("Enter car Number");
					String carNu = sc.next();
					p.findCar(carNu);
					break;
				case 2:
					System.out.println("Enter bike Number");
					String bikeNU = sc.next();
					p.findBike(bikeNU);
					break;
				case 3:
				vehfind = false;
					break;
				default:
				System.out.println("Enter valid choice");
					break;
			}
			
		}
		
	}
}
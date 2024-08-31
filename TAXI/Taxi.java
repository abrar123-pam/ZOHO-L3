import java.util.ArrayList;
import java.util.List;

public class Taxi{
	static int taxiCount = 0;
	int id;
	char currSpot;
	int totalEarnings;
	int freeTime;
	List<String> trips;
	
	public Taxi(){
		currSpot = 'A';
		totalEarnings = 0;
		freeTime = 6;
		taxiCount += 1;
		trips = new ArrayList<>();
		id = taxiCount;
	}
	
	public void setDetails(char currSpot,int totalEarnings,int freeTime, String trip){
		this.currSpot = currSpot;
		this.totalEarnings = totalEarnings;
		this.freeTime = freeTime;
		this.trips.add(trip);
	}
	
	public void printDetails(){
		
		System.out.println("------TRIP DETAILS------");
		System.out.println("Taxi - "+this.id +" Total Earnings - "+ this.totalEarnings);
		System.out.println("Taxi id       BookingID       CustomerID       From       To       PickupTime       DropTime       Amount");
		for(String trip : trips)
        {
            System.out.println(id + "        " + trip);
        }
		
		System.out.println("------------------------------------------------------------------------");
		
	}
	
	public void printTaxiDetails()
    {
        System.out.println("Taxi - "+ this.id + " Total Earnings - " + this.totalEarnings + " Current spot - " + this.currSpot +" Free Time - " + this.freeTime);
    }
}
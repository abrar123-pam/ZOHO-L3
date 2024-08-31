import java.util.*;
//Create an electricity bill generation CLI application to calculate the amount for both domestic and commercial cases.

class EB{

	 public static double calculateBill(int unitsConsumed) {
        double totalCost = 0.0;
        
        if(unitsConsumed <= 100) {
            totalCost += 100 * 0; 
        } else if(unitsConsumed <= 200) {
            totalCost += 100 * 0; 
            totalCost += (unitsConsumed - 100) * 3.5;
        } else if(unitsConsumed <= 500) {
            totalCost += 100 * 0;
            totalCost += 100 * 3.5; 
            totalCost += (unitsConsumed - 200) * 4.6; 
        } else {
            totalCost += 100 * 0; 
            totalCost += 100 * 3.5; 
            totalCost += 300 * 4.6; 
            totalCost += (unitsConsumed - 500) * 6.6; 
        }
        
        
        
        return totalCost;
    }

	public static void findDomestic(int pr, int cr){
		
		int tr = cr - pr;
		double bill = calculateBill(tr);
		System.out.println("---------- EB Calculations ----------");
		System.out.println("      Total Cost = " + bill);
		System.out.println("      Fixed Charges = "+ 30);
		bill += 30;
		System.out.println("      Total Cost with charges = " + bill);
		
	}


	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Previous meter reading : ");
		int pr = sc.nextInt();
		System.out.print("Current meter reading : ");
		int cr = sc.nextInt();
		
		findDomestic(pr,cr);
		//findCommercial(pr,cr);
		
	}
}
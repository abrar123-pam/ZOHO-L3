

public class Calculator{

	public static void main(String[] args){
	
		Scanner sc = new Scanner(System.in);
		
		boolean loop = true;
		
		
		while(loop){
		
			System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Percentage");
			System.out.print("Enter your choice : ");
			int choice = sc.nextInt();
			
			
			switch(choice){
				
				case 1:
					System.out.print("Enter value 1 : ");
					int v1 = sc.nextInt();
					System.out.print("Enter value 2 : ");
					int v2 = sc.nextInt();
					
					add(v1,v2);
					break;
					
				case 2:
					break;
					
				case 3:
					break;
					
				case 4:
					break;
					
				case 5:
					break;
					
				case 6:
					break;
					
				default:
					System.out.println("Enter valid choice");
					break;
			}
				
		}
	}
	
	
	
}
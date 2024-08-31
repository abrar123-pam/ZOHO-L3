import java.util.*;

class Balloon{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		DropBalloons db = new DropBalloons();
		System.out.println("Enter Matrix Row : ");
		int r = sc.nextInt();
		System.out.println("Enter Matrix Column  :");
		int c = sc.nextInt();
		
		char[][] mat = new char[r][c];
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				mat[i][j] = '-';
			}
		}
		
		DropBalloons.display(mat,r,c);
		
		boolean loop = true;
		
		while(loop){
			System.out.println("Enter the column number :  ");
			int c_number = sc.nextInt();
			System.out.println("Enter the color of balloon : ");
			char color = sc.next().charAt(0);
			if(db.putBalloon(mat,r,c,c_number-1,color)){
				db.burstBalloon(mat,r,c);
				DropBalloons.display(mat,r,c);
				System.out.println("Do you wish to continue(Y/N) : ");
				char check = sc.next().charAt(0);
				
				if(check == 'n' || check == 'N'){
					System.out.println("Exitting..........");
					loop = false;
				}
			}else{
				System.out.println("Column is filled completely. Program is terminated. ");
				loop = false;
			}
			
			
		}
	}	
}

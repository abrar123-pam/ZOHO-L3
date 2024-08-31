import java.util.*;

class Stamping{
	
	public static int getExactMatch(int row, int sh){
		int temp = row;
		int q = temp/sh;
		int r = row % sh;
	
		return q+r;
		
	}
	
	public static boolean checkForPosiibles(int[][] arr, int r, int c, int sh, int sw){
		
		int possible = getExactMatch(r,sh);
		int st = 1;
		
		while(st<=possible){
			for(int i=0;i<r;i++){
				int cou = sw;
				for(int j=0;j<c;j++){
					if(arr[i][j] != 1 && cou!=0){
						arr[i][j] = -1;
						cou--;
					}
				}
				
			}
			st++;
		}
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
			
		}
		
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				if(arr[i][j] == 0){
					return false;
				}
			}
			
		}
		return true;
	}



	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter rows : ");
		int r = sc.nextInt();
		System.out.println("Enter cols : ");
		int c = sc.nextInt();
		
		int[][] arr = new int[r][c];

		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		System.out.println("Enter stampHeight : ");
		int stampHeight = sc.nextInt();
		System.out.println("Enter stampWeight : ");
		int stampWeight = sc.nextInt();
		
		
		boolean ans = checkForPosiibles(arr,r,c,stampHeight,stampWeight);
		System.out.println(ans);
	}
}
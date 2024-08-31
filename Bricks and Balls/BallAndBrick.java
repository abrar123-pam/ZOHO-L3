import java.util.*;

class BallAndBrick{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		String[][] arr = new String[size][size];
		
		printPattern(size,arr);
		System.out.println("  Welcome to Bricks and Balls Game  ");
		display(size,arr);
		
		System.out.println("Do you want to start the game[Y/N]");
		char start = sc.next().charAt(0);
		
		System.out.println("Enter Ball Count ");
		int ballCount = sc.nextInt();
		if(start == 'Y' || start == 'y'){
			startGame(sc,arr,size,ballCount);
		}else{
			System.out.println("  Come Back Again!!!!!!!!!  ");
		}
	}
	
	public static void startGame(Scanner sc, String[][] arr,int size,int ballCount){
		
		boolean loop = true;
		System.out.println("------------------");
		System.out.println("Game Guide");
		System.out.println(" st -> Start\n lt -> Left\n rt -> Right\n Exit -> Exit Game");
		System.out.println("------------------");
		while(loop){
			System.out.println("Enter your choice");
			String userChoice = sc.next();
			
			if(userChoice.equals("Exit") || userChoice.equals("e")){
				loop = false;
			}else{			
				changeGame(userChoice,arr,size,ballCount);
			}
		}
	}
	
	public static void changeGame(String userChoice,String[][] arr,int size, int ballCount){
		int[] currBallPosition = findBallPosition(arr,size);
		int cbr = currBallPosition[0];
		int cbc = currBallPosition[1];
		
		if(userChoice.equals("st")){
			moveStraight(arr,size,cbr,cbc);
			display(size,arr);
			System.out.println("Ball Count : "+ballCount);
		}else if(userChoice.equals("lt")){
			int[] mPosition = moveDiagnalLeft(arr,size,cbr,cbc);
			int mr = mPosition[0];
			int mc = mPosition[1];
			arr[cbr][cbc] = "g";
			arr[size-1][mc] = "o";
			display(size,arr);
			ballCount--;
			System.out.println("Ball Count : "+ballCount);
			
		}else if(userChoice.equals("rt")){
			int[] mPosition = moveDiagnalRight(arr,size,cbr,cbc);
			int mr = mPosition[0];
			int mc = mPosition[1];
			arr[cbr][cbc] = "g";
			arr[size-1][mc] = "o";
			display(size,arr);
			ballCount--;
			System.out.println("Ball Count : "+ballCount);
		}
	}
	
	public static int[] moveDiagnalLeft(String[][] arr, int size, int cbr, int cbc){
		
		if(cbr < 0 || cbc < 0){
			return new int[]{-1,-1};
		}
		
		if(arr[cbr][cbc].equals("w")){
			boolean hitBrick = false;
			for(int i=0;i<arr[0].length;i++){
				if(arr[cbr][i].equals("1")){
					arr[cbr][i] = " ";
					int[] pos = new int[2];
					pos[0] = cbr;
					pos[1] = i;
					return pos;
				}
			}
			
			if(!hitBrick){
				return new int[]{size, size/2};
			}
		}
		
		
	
		return moveDiagnalLeft(arr,size,cbr-1,cbc-1);
	}
	
	public static int[] moveDiagnalRight(String[][] arr, int size, int cbr, int cbc){
		if(cbr >= size || cbc >= size){
			return new int[]{-1,-1};
		}
		
		if(arr[cbr][cbc].equals("w")){
			boolean hitBrick = false;
			for(int i=arr[0].length-1; i>=0; i--){
				if(arr[cbr][i].equals("1")){
					arr[cbr][i] = " ";
					int[] pos = new int[2];
					pos[0] = cbr;
					pos[1] = i;
					return pos;
				}
			}
			if(!hitBrick){
				return new int[]{size, size/2};
			}
		}
		return moveDiagnalRight(arr, size, cbr - 1, cbc + 1);
	}

	
	public static void moveStraight(String[][] arr, int size, int cbr, int cbc){
		for(int i = size-1;i>=0;i--){
			for(int j=size-1;j>=0;j--){
				if(arr[i][cbc].equals("1")){
					arr[i][cbc] = " ";
					return;
				}
			}
		}
		
	}
	
	public static int[] findBallPosition(String[][] arr, int size){
		int[] curr = new int[2];
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				if(arr[i][j].equals("o")){
					curr[0] = i;
					curr[1] = j;
				}
			}
		}
		
		return curr;
		
	}
	
	public static void display(int size, String[][] arr){
		
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void printPattern(int size, String[][] arr){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++){
				
				if(i == 0){
					arr[i][j] 	= "w";
				}else if(i == size-1){
					arr[i][j] = "g";
					arr[j][0] = "w";
					arr[j][size-1] = "w";
					arr[i][size/2] = "o";
					
				}else if(j == 0 || j == size-1){
					arr[i][j] = "w";
				}else if(i == 2&& j ==2 || i==2 && j == 3 || i == 2 && j == 4
				|| i== 3 && j == 2 || i== 3 && j == 3 || i == 3 && j == 4){
					arr[i][j] = "1";
				}
				
				else {
					arr[i][j] = " ";
				}
			}
		}
		
		
	}
}
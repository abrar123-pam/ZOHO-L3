import java.util.*;

class DungeonGame{
	static int min = Integer.MAX_VALUE;
	static int MonsterPathCount = 0;
	static String path="";
	static int pitsMin = Integer.MAX_VALUE;
	
	static int lastMin = Integer.MAX_VALUE;
	static int minTriggerCount = 0;
	public static void findMinPath(int ar, int ac,int gr,int gc, int r, int c, int[][] grid,int cnt,String p){
	
		if(ar == gr && ac == gc){
			if(cnt<min) {
				min=cnt;
				path=p;
			}
			return;
		}
		
		if(ar < 0 || ar >= r || ac < 0 || ac >= c || grid[ar][ac] == 1){
			return;
		}
		
		grid[ar][ac] = 1;
		
		findMinPath(ar+1,ac,gr,gc,r,c,grid,cnt+1,p+"D");
		findMinPath(ar,ac+1,gr,gc,r,c,grid,cnt+1,p+"R");
		findMinPath(ar-1,ac,gr,gc,r,c,grid,cnt+1,p+"U");
		findMinPath(ar,ac-1,gr,gc,r,c,grid,cnt+1,p+"L");
		grid[ar][ac] = 0;
	} 
	
	public static boolean Monster(int ar, int ac, int gr, int gc, int mr, int mc,int r, int c, int[][] grid){
		int minMonster = 0;
		if(MonsterPathCount == 0){
			findMinPath(mr,mc,gr,gc,r,c,grid,0,"");
			minMonster = min;
		}
		min = Integer.MAX_VALUE;
		findMinPath(ar,ac,gr,gc,r,c,grid,0,"");
		int minAdventure = min;
		
		if(minMonster < minAdventure) return false;
	
		return true;
	}
	
	public static void DisplayPath(int ar, int ac){
		
		System.out.println(path);
		System.out.print("Path: ->");
		System.out.print("("+ (ar+1)  + "," + (ac+1) +")");
		
		
		for(int i=0;i<path.length();i++){
			char ch = path.charAt(i);
			if(ch=='R'){
				ac++;
				System.out.print("("+ (ar+1)  + "," + (ac+1) +")");
			}
			if(ch == 'D'){
				ar++;
				System.out.print("("+ (ar+1)  + "," + (ac+1) +")");
			}
			if(ch == 'L'){
				ac--;
				System.out.print("("+ (ar+1)  + "," + (ac+1) +")");
			}
			
			if(ch =='U'){
				ar--;
				System.out.print("("+ (ar+1)  + "," + (ac+1) +")");
			}
		}
	}
	
	public static void findPitsMinPath(int ar,int ac, int gr,int gc, int r, int c, int[][] grid,int cnt, int[][] pitsArr){
		
		if(ar == gr && ac == gc){
			if(cnt<min) {
				pitsMin=cnt;
			}
			return;
		}
		for(int i=0;i<pitsArr.length;i++){
			for(int j=0;j<1;j++){
				int pr = pitsArr[i][j];
				int pc = pitsArr[i][j+1];
				
				if(ar == pr && ac == pc){
					return;
				}
			}
		}
		
		if(ar < 0 || ar >= r || ac < 0 || ac >= c || grid[ar][ac] == 1){
			return;
		}
		
		grid[ar][ac] = 1;
		
		findPitsMinPath(ar+1,ac,gr,gc,r,c,grid,cnt+1,pitsArr);
		findPitsMinPath(ar,ac+1,gr,gc,r,c,grid,cnt+1,pitsArr);
		findPitsMinPath(ar-1,ac,gr,gc,r,c,grid,cnt+1,pitsArr);
		findPitsMinPath(ar,ac-1,gr,gc,r,c,grid,cnt+1,pitsArr);
		grid[ar][ac] = 0;
		
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dimensions of the dungeon(Row * Column) : ");
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[][] grid = new int[row][col];
		System.out.println("Position of adventurer : ");
		int[] aPos = new int[2];
		for(int i=0;i<2;i++){
			aPos[i] = sc.nextInt();
		}
		
		System.out.println("Position of Monster : ");
		int mr = sc.nextInt() -1;
		int mc = sc.nextInt() - 1;
		
		System.out.println("Position of Triggers : ");
		int tr = sc.nextInt() -1;
		int tc = sc.nextInt() - 1; 
		
		System.out.println("Position of Gold : ");
		int[] gPos = new int[2];
		for(int i=0;i<2;i++){
			gPos[i] = sc.nextInt();
		}
		int ar = aPos[0]-1;
		int ac = aPos[1]-1;
		int gr = gPos[0]-1;
		int gc = gPos[1]-1;
		
		System.out.println("Enter no of pits : ");
		int pi = sc.nextInt();
		
		int[][] pitsArr = new int[pi][2];
		for(int i=0;i<pi;i++){
			for(int j=0;j<2;j++){
				pitsArr[i][j] = sc.nextInt();
			}
		}
		//System.out.println("Minimum Number of steps is : " + min);
		
		//findMinPath(ar,ac,gr,gc,row,col,grid,0,"");
		
		//System.out.println("Minimum Number of steps is : " + min);
		
		//Module 6
	/*	if(Monster(ar,ac,gr,gc,mr,mc,row,col,grid)){
			findPitsMinPath(ar,ac,gr,gc,row,col,grid,0,pitsArr);
			
			if(min < pitsMin){
				System.out.println("Minimum Number of steps is : "+min);
			}else{
				System.out.println("Minimum Number of steps is : "+pitsMin);
			}
		}else{
				System.out.println("No Possible Solution");
			
		} */
		
	/*	if(Monster(ar,ac,gr,gc,mr,mc,row,col,grid)){
			System.out.println("Minimum Number of steps is : " + min);
			
			DisplayPath(ar,ac);
		}else{
			Monster(ar,ac,tr,tc,mr,mc,row,col,grid);
			String Tpath = path;
			int Tcount = min;
			min = Integer.MAX_VALUE;
			Monster(tr,tc,gr,gc,mr,mc,row,col,grid);
			System.out.println("Minimum Number of steps is : " + min+Tcount);
			path = Tpath + path;
			DisplayPath(ar,ac);
		} */
		
		
			//DisplayPath(ar,ac);
		
	// Final Module
	
	
		LastModule(ar,ac,gr,gc,mr,mc,tr,tc,row,col,pitsArr,grid,0);
		
		
		
	}
	
	
	public static void LastModule(int ar, int ac, int gr, int gc, int mr, int mc, int tr, int tc,int row, int col, int[][] pitsArr, int[][] grid, int cnt){
		
		int minTrigger = 0;
		int minLAst =1;
		if(minTriggerCount == 0){
			findPitsMinPath(ar,ac,tr,tc,row,col,grid,0,pitsArr);
			minTrigger = pitsMin;
			System.out.println(minTrigger);
		}
		
		pitsMin = Integer.MAX_VALUE;
		findPitsMinPath(tr,tc,gr,gc,row,col,grid,0,pitsArr);
		 minLAst += pitsMin;
		
		//System.out.println("Minimum Number of steps is : "+ minTrigger);
		System.out.println("Minimum Number of steps is : "+ minLAst);
		
	}
	
}


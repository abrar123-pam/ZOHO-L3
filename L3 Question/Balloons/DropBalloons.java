class DropBalloons{

	public static void display(char[][] mat, int r, int c){
		System.out.println("Contents of the ");
		for(int i=0;i<r;i++){
			for(int j=0;j<c;j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static boolean checkBoundries(char[][] mat,int r,int c){
			
			boolean flag = false;
			for(int j=0;j<c;j++){
				if(mat[0][j] == '-'){
					flag = true;
				}
			}
			
			return flag;	
	}
	
	public boolean putBalloon(char[][] mat,int r,int c,int c_number,char color){
		
		if(!checkBoundries(mat,r,c)){
			return false;
		}
		
		
		for(int i=r-1;i>=0;i--){
			for(int j=0;j<c;j++){
				
				if(mat[i][c_number] != '-'){
					if(mat[i][c_number-1] == '-'){
						mat[i][c_number-1] = color;
						return true;
					}else if(mat[i][c_number+1] == '-'){
						mat[i][c_number+1] = color;
						return true;
					}
				}else{
					if(mat[i][c_number] == '-'){
						mat[i][c_number] = color;
						return true;
					} 
				}
				
				
			}
			
		}
		
		return true;
	}
	
	
	public static void burstBalloon(char[][] mat, int r, int c) {
    for (int j = 0; j < c; j++) { 
        int count = 0;
        char ch = '-';
        for (int i = 0; i < r; i++) { 
            if (mat[i][j] != '-') {
                if (ch == '-') {
                    ch = mat[i][j];
                    count = 1;
                } else if (mat[i][j] == ch) {
                    count++;
                } else { 
                    ch = '-';
                    count = 0;
                    break;
                }
            }
        }
        if (count == r) {
            for (int i = 0; i < r; i++) {
                mat[i][j] = '-'; 
            }
        }
    }
}
	
/*	public static void burstBalloon(char[][] mat, int r, int c) {
    for (int i = 0; i < r; i++) { 
        int count = 0;
        char ch = '-';
        for (int j = 0; j < c; j++) { 
            if (mat[i][j] != '-') {
                if (ch == '-') {
                    ch = mat[i][j];
                    count = 1;
                } else if (mat[i][j] == ch) {
                    count++;
                } else { 
                    ch = '-';
                    count = 0;
                    break;
                }
            }
        }
        if (count == c) { 
            for (int j = 0; j < c; j++) {
                mat[i][j] = '-'; 
            }
        }
    }

    for (int j = 0; j < c; j++) { 
        int count = 0;
        char ch = '-';
        for (int i = 0; i < r; i++) { 
            if (mat[i][j] != '-') {
                if (ch == '-') {
                    ch = mat[i][j];
                    count = 1;
                } else if (mat[i][j] == ch) {
                    count++;
                } else { 
                    ch = '-';
                    count = 0;
                    break;
                }
            }
        }
        if (count == r) { 
            for (int i = 0; i < r; i++) {
                mat[i][j] = '-'; 
            }
        }
    }
}*/

}
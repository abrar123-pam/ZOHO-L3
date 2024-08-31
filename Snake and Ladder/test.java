import java.util.*;

class test{

    public static void display(String[][] arr, int r, int c){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; 
    }

    public static void rotateDice() {
        int roll = rollDice(); 
        System.out.println("You rolled: " + roll);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter rows : ");
        int r = sc.nextInt();
        
        System.out.print("Enter cols : ");
        int c = sc.nextInt();
        
        String[][] arr = new String[r][c];
        
        int st = r * c;

        for(int i = 0; i < r; i++){
            if(i % 2 == 0) {
                for(int j = 0; j < c; j++) {
                    arr[i][j] = String.valueOf(st--);
                }
            } else {
                for(int j = c - 1; j >= 0; j--){
                    arr[i][j] = String.valueOf(st--);
                }
            }
        }
        
        display(arr, r, c);

        boolean loop = true;
        
        while(loop){
            System.out.println("1. Rotate Dice\n2. Exit");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    rotateDice();
                    break;
                case 2:
                    System.out.println("------Exiting Game---------");
                    loop = false;
                    break;
                default:
                    System.out.println("Enter Valid Choice");
                    break;
            }
        }
    }
}

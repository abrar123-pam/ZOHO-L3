import java.util.*;

class Main {

    public static void display(String[][] arr, int r, int c){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void displaywithsnakesandladders(String[][] arr, int r, int c, int[][] playerPositions){
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                boolean playerPresent = false;
                for(int k = 0; k < playerPositions.length; k++){
                    if(i == playerPositions[k][0] && j == playerPositions[k][1]){
                        System.out.print("A ");
                        playerPresent = true;
                        break;
                    }
                }
                if(!playerPresent){
                    if(arr[i][j].equals("40") || arr[i][j].equals("3")){
                        System.out.print("s1 ");
                    } else if(arr[i][j].equals("43") || arr[i][j].equals("18")){
                        System.out.print("s2 ");
                    } else if(arr[i][j].equals("27") || arr[i][j].equals("5")){
                        System.out.print("s3 ");
                    } else if(arr[i][j].equals("54") || arr[i][j].equals("31")){
                        System.out.print("s4 ");
                    } else if(arr[i][j].equals("89") || arr[i][j].equals("53")){
                        System.out.print("s5 ");
                    } else if(arr[i][j].equals("66") || arr[i][j].equals("45")){
                        System.out.print("s6 ");
                    } else if(arr[i][j].equals("76") || arr[i][j].equals("58")){
                        System.out.print("s7 ");
                    } else if(arr[i][j].equals("99") || arr[i][j].equals("41")){
                        System.out.print("s8 ");
                    } else if(arr[i][j].equals("25") || arr[i][j].equals("4")){
                        System.out.print("l1 ");
                    } else if(arr[i][j].equals("46") || arr[i][j].equals("13")){
                        System.out.print("l2 ");
                    } else if(arr[i][j].equals("49") || arr[i][j].equals("33")){
                        System.out.print("l3 ");
                    } else if(arr[i][j].equals("69") || arr[i][j].equals("50")){
                        System.out.print("l4 ");
                    } else if(arr[i][j].equals("63") || arr[i][j].equals("42")){
                        System.out.print("l5 ");
                    } else if(arr[i][j].equals("81") || arr[i][j].equals("62")){
                        System.out.print("l6 ");
                    } else if(arr[i][j].equals("92") || arr[i][j].equals("74")){
                        System.out.print("l7 ");
                    } else {
                        System.out.print(arr[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println("\n\n---------------------------------------------------------------------");
    }

    public static int rollDice() {
        Random rand = new Random();
        return rand.nextInt(6) + 1; 
    }

    public static int rotateDice() {
        return rollDice();
    }

    public static void movePlayer(int[][] playerPositions, int playerIndex, int roll, String[][] arr, int r, int c) {
        int newRow = playerPositions[playerIndex][0];
        int newCol = playerPositions[playerIndex][1] + roll;

        if (newCol >= c) {
            newRow--;  
            newCol = c - 1 - (newCol - c);
        }

        playerPositions[playerIndex][0] = newRow;
        playerPositions[playerIndex][1] = newCol;

        String positionValue = arr[newRow][newCol];
        switch (positionValue) {
            case "40":
                playerPositions[playerIndex][0] = 9; 
                playerPositions[playerIndex][1] = 2;
                break;
            case "43":
                playerPositions[playerIndex][0] = 8; 
                playerPositions[playerIndex][1] = 2;
                break;
			case "27":
            playerPositions[playerIndex][0] = 9; 
            playerPositions[playerIndex][1] = 4;
            break;
		case "54":
            playerPositions[playerIndex][0] = 6; 
            playerPositions[playerIndex][1] = 9;
            break;
		case "89":
            playerPositions[playerIndex][0] = 4; 
            playerPositions[playerIndex][1] = 7;
            break;
		case "66":
            playerPositions[playerIndex][0] = 5; 
            playerPositions[playerIndex][1] = 4;
            break;
		case "76":
            playerPositions[playerIndex][0] = 4; 
            playerPositions[playerIndex][1] = 2;
            break;
		case "99":
            playerPositions[playerIndex][0] = 5; 
            playerPositions[playerIndex][1] = 0;
            break;
		case "4":
            playerPositions[playerIndex][0] = 7; 
            playerPositions[playerIndex][1] = 4;
            break;
		case "13":
            playerPositions[playerIndex][0] = 5; 
            playerPositions[playerIndex][1] = 5;
            break;
		case "33":
            playerPositions[playerIndex][0] = 5; 
            playerPositions[playerIndex][1] = 8;
            break;
		case "50":
            playerPositions[playerIndex][0] = 3; 
            playerPositions[playerIndex][1] = 8;
            break;
		case "42":
            playerPositions[playerIndex][0] = 3; 
            playerPositions[playerIndex][1] = 2;
            break;
		case "62":
            playerPositions[playerIndex][0] = 1; 
            playerPositions[playerIndex][1] = 0;
            break;
		case "74":
            playerPositions[playerIndex][0] = 0; 
            playerPositions[playerIndex][1] = 8;
            break;
            default:
                break;
        }
    }
	public static void start(Scanner sc, String[][] arr, int r, int c, int[][] playerPositions) {
    System.out.println("Board with Snakes and Ladder");
    boolean playerLoop = true;
    int currentPlayer = 0; 

    while (playerLoop) {
        System.out.println("Player " + (currentPlayer + 1) + "'s turn. Do you want to Roll the Dice [Y|N]");
        char ch = sc.next().charAt(0);

        switch (ch) {
            case 'y':
                int roll = rotateDice();
                System.out.println("Outcome of Dice Thrown : " + roll);
                movePlayer(playerPositions, currentPlayer, roll, arr, r, c);
                displaywithsnakesandladders(arr, r, c, playerPositions);
                if (playerPositions[currentPlayer][0] == 0 && playerPositions[currentPlayer][1] == c - 1) {
                    System.out.println("Player " + (currentPlayer + 1) + " reached the end of the board.");
                    playerLoop = false;
                } else {
                    currentPlayer = (currentPlayer + 1) % playerPositions.length; // Move to the next player
                }
                break;
            case 'n':
                playerLoop = false;
                break;
            default:
                System.out.println("Enter valid choice");
                break;
        }
    }
}



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows : ");
        int r = sc.nextInt();
        
        System.out.print("Enter cols : ");
        int c = sc.nextInt();
        
        System.out.print("Enter the total number of players: ");
        int totalPlayers = sc.nextInt();
        int[][] playerPositions = new int[totalPlayers][2];

        for (int i = 0; i < totalPlayers; i++) {
            playerPositions[i][0] = r - 1; 
            playerPositions[i][1] = 0; 
        }

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
            System.out.println("1. Start Game\n2. Exit");
            int choice = sc.nextInt();
            
            switch(choice){
                case 1:
                    start(sc, arr, r, c, playerPositions);
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

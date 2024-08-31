import java.util.*;

class demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] liftArray = new int[5][11];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                if (j == 0) {
                    liftArray[i][j] = 1;
                } else {
                    liftArray[i][j] = 0;
                }
            }
        }
        boolean loop = true;
        displayLiftPosition(liftArray);
        while (loop) {

            System.out.println("1. Do you want to go in lift\n2. Exit\n3. Restrict Lift\n4. Assign Capacity to lift\n5. under Maintanence\n6. release");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println();
                    System.out.print("Enter Current floor : ");
                    int cf = sc.nextInt();

                    System.out.print("Enter Destination floor : ");
                    int df = sc.nextInt();
                    takeUserToFloor(liftArray, cf, df);
                    break;
                case 2:
                    loop = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }

    public static void takeUserToFloor(int[][] liftArray, int cf, int df) {
        int minDistance = Integer.MAX_VALUE;
        int nearestLift = -1;
        int curr = -1;
        int direction = cf - df; 

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                if (liftArray[i][j] == 1) {
                    int distance = Math.abs(cf - j);
                    if (distance < minDistance) {
                        minDistance = distance;
                        nearestLift = i;
                        curr = j;
                    }
                }
            }
        }

        List<Integer> closestLifts = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                if (liftArray[i][j] == 1 && Math.abs(cf - j) == minDistance) {
                    closestLifts.add(i);
                }
            }
        }

        if (closestLifts.size() > 1) {
            for (int lift : closestLifts) {
                if ((direction > 0 && df > curr) || (direction < 0 && df < curr)) {
                    nearestLift = lift;
                    break;
                }
            }
        }

        System.out.println("Nearest Lift: L" + (nearestLift + 1));
        liftArray[nearestLift][curr] = 0;
        liftArray[nearestLift][df] = 1;
        displayLiftPosition(liftArray);
    }

    public static void displayLiftPosition(int[][] liftArray) {
        System.out.println("L1  L2  L3  L4  L5");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 11; j++) {
                if (liftArray[i][j] == 1) {
                    System.out.print(j + "   ");
                }
            }
        }
        System.out.println();
    }
}

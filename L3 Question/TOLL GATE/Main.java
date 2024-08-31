import java.util.*;

class Main {

    public static final int TOLL_RATE_CAR = 100;
    public static final int TOLL_RATE_LORRY_BUS = 120;
    public static final int TOLL_RATE_BIKE_AUTO = 0; 
	public static Helper helper = new Helper();
    public static void setToll(String[] tollArray, int points, int tollCount, char[] selectedTolls) {
        List<Character> selectedTollsList = new ArrayList<>();
        for (char toll : selectedTolls) {
            selectedTollsList.add(toll);
        }

        for (int i = 0; i < points; i++) {
            if (selectedTollsList.contains(tollArray[i].charAt(0))) {
                tollArray[i] = "T" + (selectedTollsList.indexOf(tollArray[i].charAt(0)) + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of points: ");
        int points = sc.nextInt();

        String[] tollArray = new String[points];
        int m = 65;
        for (int i = 0; i < points; i++) {
            tollArray[i] = (char) m++ + "";
        }

        for (int i = 0; i < points; i++) {
            System.out.print(tollArray[i] + " ");
        }
        System.out.println();
        System.out.println("Enter number of Toll: ");
        int tollCount = sc.nextInt();

        char[] selectedTolls = new char[tollCount];
        System.out.println("Enter selected tolls:");
        for (int i = 0; i < tollCount; i++) {
            selectedTolls[i] = sc.next().charAt(0);
        }

        setToll(tollArray, points, tollCount, selectedTolls);

        boolean loop = true;

        while (loop) {
            System.out.println("1. Entry Vehicles\n2. Display Toll details\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    getUser(sc, tollArray);
                    break;
				case 2:
					displayTollDetails();
					break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }

        }
    }

    public static void getUser(Scanner sc, String[] tollArray) {
        System.out.println("Enter vehicle Number: ");
        String vNum = sc.next();

        System.out.println("Select vehicle type: ");
        System.out.println("1. Bike");
        System.out.println("2. Auto");
        System.out.println("3. Car");
        System.out.println("4. Lorry/Bus");
        int typeChoice = sc.nextInt();

        String vType = "";
        switch (typeChoice) {
            case 1:
                vType = "Bike";
                break;
            case 2:
                vType = "Auto";
                break;
            case 3:
                vType = "Car";
                break;
            case 4:
                vType = "Lorry/Bus";
                break;
            default:
                System.out.println("Invalid choice, setting vehicle type to Unknown");
                vType = "Unknown";
                break;
        }

        System.out.println("Is VIP user? (yes/no): ");
        String vip = sc.next();
        System.out.println("-----------------------------");
        System.out.println("        Road Map ");
        for (int i = 0; i < tollArray.length; i++) {
            System.out.print(tollArray[i] + " ");
        }
        System.out.println();
        System.out.println("-----------------------------");
        System.out.println("Start Point ");
        String start = sc.next();

        System.out.println("Destination ");
        String dest = sc.next();

        int distance = calculateDistance(start, dest,tollArray); 
        int toll = calculateToll(distance, vType, vip.equals("yes"));
        System.out.println("Total Toll Paid: $" + toll);
		
		helper.updateTollDetails(dest, new User(vNum, vType, vip, start, dest));
    }

    public static int calculateDistance(String start, String dest, String[] tollArray) {
		int startIndex = -1;
		int destIndex = -1;
		
		for (int i = 0; i < tollArray.length; i++) {
			if (tollArray[i].equals(start)) {
				startIndex = i;
			}
			if (tollArray[i].equals(dest)) {
				destIndex = i;
			}
		}

		if (startIndex == -1 || destIndex == -1) {
			return -1; 
		}

		int lastTollIndex = -1;
		for (int i = destIndex; i >= 0; i--) {
			if (tollArray[i].startsWith("T")) {
				lastTollIndex = i;
			}
		}

		int distance;
		if (lastTollIndex != -1) {
			distance = Math.abs(destIndex - lastTollIndex+1) * 25;
		} else {
			distance = Math.abs(destIndex - startIndex) * 25; 
		}
		return distance;
	}

    public static int calculateToll(int distance, String vehicleType, boolean isVip) {
        int tollRate;
        switch (vehicleType) {
            case "Car":
                tollRate = TOLL_RATE_CAR;
                break;
            case "Lorry/Bus":
                tollRate = TOLL_RATE_LORRY_BUS;
                break;
            case "Bike":
            case "Auto":
                tollRate = TOLL_RATE_BIKE_AUTO;
                break;
            default:
                tollRate = 0; 
        }

        int toll = distance / 25 * tollRate;
        if (isVip) {
            toll -= (toll * 0.2);
        }
        return toll;
    }
	
	public static void displayTollDetails() {
    System.out.println("Toll Details:");
    for (Map.Entry<String, List<User>> entry : helper.tollDetails.entrySet()) {
        String toll = entry.getKey();
        List<User> users = entry.getValue();
        int totalAmount = 0;
        System.out.println("Toll " + toll + ":");
        for (User user : users) {
            int tollAmount = calculateToll(user.getEnd(), user.getVehicleType(), user.getVipUser().equals("yes"));
            System.out.println("Vehicle Number: " + user.getVehicleNumber() + ", Amount Paid: $" + tollAmount);
            totalAmount += tollAmount;
        }
        System.out.println("Total Amount Charged: $" + totalAmount);
        System.out.println();
    }
}

}



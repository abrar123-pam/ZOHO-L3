import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loop = true;
        Server server = new Server();
        List<String> patientNames = new ArrayList<>(); // Store patient names

        while (loop) {
            System.out.println("1. Patient\n2. Out Patients records\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createUser(sc, server, patientNames); // Pass patientNames list
                    break;
                case 2:
                    displayPatientTime(server, patientNames); // Display patient details
                    displayResult(server);
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public static void createUser(Scanner sc, Server server, List<String> patientNames) {
        System.out.println("Enter name: ");
        String name = sc.next();
        patientNames.add(name); // Add patient name to the list
        double time = 0.00;
        if (!server.user_map.containsKey(name)) {
            System.out.println("Creating an entry for the patient.");
            System.out.println("Enter in-time: ");
            time = sc.nextDouble();
            User user = new User(name, time);
            server.addUser(name, user);
        }

        System.out.println("Interacting with medical professionals... 10 minutes");
        time = server.addTime(time, 10);
		try{
			Thread.sleep(1500);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}

        
        int doctorCheckTime = (int) (Math.random() * (20 - 2 + 1) + 2);
		System.out.println("Meeting with the doctor... "+doctorCheckTime);
        time = server.addTime(time, doctorCheckTime);
		try{
			Thread.sleep(1500);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}

        System.out.println("Pharmacy providing medicines... 5 minutes");
        time = server.addTime(time, 5);
		try{
			Thread.sleep(1500);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}

        System.out.println("Sorry for the wait. Thank you for your patience.");
        double outTime = time;
		try{
			Thread.sleep(1500);
		}catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
        System.out.println("Patient check-up completed successfully.");
        server.completeCheckUp(name, outTime);
        server.addNextUser();
    }

    public static void displayResult(Server server) {
        System.out.println("Total number of out patient records: " + server.user_map.size());
        System.out.println("Total number of out patients currently in queue: " + server.queue.size());
    }

    public static void displayPatientTime(Server server, List<String> patientNames) {
    System.out.println("Patient Details:");
    for (String name : patientNames) {
        double patientTime = server.user_map.get(name).getTime();
        String formattedTime = String.format("%.2f", patientTime);
		System.out.println("------------------------------------------------------------------------");
        System.out.println("Patient Name: " + name+"     Patient Time: " + formattedTime + " minutes");
		System.out.println("------------------------------------------------------------------------");
        
    }
}

}

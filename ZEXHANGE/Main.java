import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		StoreDetails sd = new StoreDetails();
		
		while(loop){
			System.out.println("1. Create Account\n2. Login\n3.Exit"); 
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice){
				case 1:
					createUser(sc,sd);
					break;
				case 2:
					login(sc,sd);
					break;
				case 3:
					System.out.println("-------EXITTING-------");
					loop = false;
					break;
				default:
					System.out.println("Enter valid choice");
					break;
			}
		}
	}
	
	public static void login(Scanner sc,StoreDetails sd){
		boolean loopLogin = true;
		
		while(loopLogin){
			System.out.println("1. ZE-Agent Login\n2. User Login\n3. Exit");
			System.out.println("Enter your choice : ");
			int logchoice = sc.nextInt();
			
			switch(logchoice){
				case 1:
					System.out.println("Enter email");
					String Aemail = sc.next();
					System.out.println("Enter password");
					String Apass = sc.next();
					//UserMgmtPanel um = new UserMgmtPanel(Aemail,Apass);
					if(Aemail.equals("johnze@gmail.com") && Apass.equals("ze1") ||
						Aemail.equals("maryze@gmail.com") && Apass.equals("ze2")){
						userManagementPanel(sc,sd);
					}else{
						System.out.println("Invalid User");
					}
					break;
				case 2:
					System.out.println("Enter email");
					String Uemail = sc.next();
					System.out.println("Enter password");
					String Upass = sc.next();
					if(isValidUser(Uemail,Upass,sd)){
						userAccountPanel(sc,Uemail,Upass,sd);
					}else{
						System.out.println("Invalid User");
					}
					break;
				case 3:
					loopLogin = false;
					break;
				default:
					System.out.println("Enter valid choice");
					break;
			}
		}
		
	}
	
	public static void userAccountPanel(Scanner sc,String email,String pass,StoreDetails sd){
		boolean accLoop = true;
		
		while(accLoop){
			System.out.println("1. Account Details\n2. Transaction History\n3. Change Password\n4. RC Transaction\n5. ZCoin Transaction\n6. Exit");
			int accChoice = sc.nextInt();
			
			switch(accChoice){
			
				case 1:
					String zid = getZidByEmail(email, sd);
                    if (zid != null) {
                        accountDetails(zid, sd);
                    } else {
                        System.out.println("User not found.");
                    }
					break;
				case 2:
					String useZid = getZidByEmail(email, sd);
					if (useZid != null) {
						sd.displayTransactionHistory(useZid, sd);
					} else {
						System.out.println("User not found.");
					}
					break;
				case 3:
					break;
				case 4:
                    System.out.println("1. Deposit RC\n2. Withdraw RC\n3. ZE to RC Exchange");
                    int rcChoice = sc.nextInt();
                    System.out.println("Enter RC amount: ");
                    int rcAmount = sc.nextInt();
                    String userZid = getZidByEmail(email, sd);
                    if (userZid != null) {
                        sd.performRCTransaction(userZid, rcChoice, rcAmount);
                    } else {
                        System.out.println("User not found.");
                    }
					break;
				case 5:
					System.out.println("Enter RC amount: ");
                 //   int rcz = sc.nextInt();
					//sd.convertRCToZCoin(acc, rcz);
					break;
				case 6:
					accLoop = false;
					break;
				default:
					System.out.println("Enter valid choice");
					break;
			}
		}
	}
	
	public static void accountDetails(String zid, StoreDetails sd) {
        sd.displayDetails(zid);
    }
	
	public static void userManagementPanel(Scanner sc,StoreDetails sd){
		boolean umloop = true;
		
		while(umloop){
			System.out.println("1. Approve User\n2. Exit");
			int umchoice = sc.nextInt();
			
			switch(umchoice){
				case 1:
					sd.approveUser();
					break;
				case 2:
					umloop = false;
					break;
				default:
					System.out.println("enter valid choice");
					break;
			}
		}
	}
	
	public static void createUser(Scanner sc,StoreDetails sd){
		System.out.println("Full name");
		String name = sc.next();
		System.out.println("Email id");
		String email = sc.next();
		System.out.println("Phone Number");
		String number = sc.next();
		System.out.println("H_ID");
		String hid = sc.next();
		System.out.println("Password");
		String pass = sc.next();
		System.out.println("RC Deposit");
		int deposit = sc.nextInt();
		System.out.println("ZCoin Balance");
		int zCoinBalance = sc.nextInt();
		
		Account acc = new Account(name,email,number,hid,pass,deposit,zCoinBalance);
		sd.addWaitUser(acc);
		
	}
	
	private static String getZidByEmail(String email, StoreDetails sd) {
    for (Map.Entry<String, Account> entry : sd.acc_map.entrySet()) {
        if (entry.getValue().getEmail().equals(email)) {
            return entry.getKey(); 
        }
    }
    return null;
}
	
	public static boolean isValidUser(String email,String password,StoreDetails sd){
		
		return sd.checkUserLogin(email,password);
	}

}
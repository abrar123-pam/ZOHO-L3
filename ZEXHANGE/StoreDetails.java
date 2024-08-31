import java.util.*;

class StoreDetails{
    
    Map<String,Account> acc_map = new HashMap<>();
    List<Account> userDetails = new ArrayList<>();
    static int user = 0; 
    
    public void addWaitUser(Account acc){
        userDetails.add(acc);
    }
    
    public boolean checkUserLogin(String email, String pass){
        for(Account a : acc_map.values()){
            if(email.equals(a.getEmail()) && pass.equals(a.getPassword())){
                return true;
            }
        }
        return false;
    }
	
	public void convertRCToZCoin(Account acc, int rcAmount) {
        int zcoinAmount = rcAmount * 2;
        acc.withdrawRC(rcAmount);
        acc.setZCoinBalance(acc.getZCoinBalance() + zcoinAmount);
        System.out.println("RC converted to ZCoin successfully.");
    }
    
    public void displayDetails(String zid) {
        Account ac = acc_map.get(zid);
        if (ac != null) {
            
			System.out.println("========================================");
            System.out.println("ZID : " + zid);
			System.out.println("NAME : " + ac.getName());
            System.out.println("EMAIL : " + ac.getEmail());
            System.out.println("PHONE NUMBER" + ac.getNumber());
            System.out.println("H_ID" + ac.getHid());
            System.out.println("PASSWORD" + ac.getPassword());
            System.out.println("# # # WALLETS # # #");
            System.out.println("REAL COINS " + ac.getRealCoinDeposit());
            System.out.println("Z COINS " + ac.getZCoinBalance());
            System.out.println("========================================");
        } else {
            System.out.println("User not found.");
        }
    }
	
//	public void updateAccountDetails(String zid, Account acc) {
//		acc_map.put(zid, acc);
//	}


    
	 public void approveUser() {
        if (userDetails.size() == 0) {
            System.out.println("No user found");
            return;
        }

        Scanner sc = new Scanner(System.in);
        for (Account a : userDetails) {
            System.out.println("========================================");
            System.out.println(a.getName());
            System.out.println(a.getEmail());
            System.out.println(a.getNumber());
            System.out.println(a.getHid());
            System.out.println(a.getPassword());
            System.out.println(a.getRealCoinDeposit());
            System.out.println("=========APPROVE[Y]/ REJECT[N]=======");
            char ch = sc.next().charAt(0);
            if (ch == 'Y' || ch == 'y') {
                String zid = "ZID " + user;
                addNewUser(zid, a);
                user++;
                System.out.println("User Added Successfully");
            } else {
                System.out.println("Waitlisted");
            }
        }
        userDetails.clear(); 
    }

    public void addNewUser(String zid,Account acc){
        acc_map.put(zid,acc);    
    }
	
	public void performRCTransaction(String zid, int rcChoice, int rcAmount) {
        Account acc = acc_map.get(zid);
        if (acc != null) {
            switch (rcChoice) {
                case 1:
                    acc.depositRC(rcAmount);
					acc.addTransaction("System", acc.getEmail(), rcAmount);
                    break;
                case 2:
                    acc.withdrawRC(rcAmount);
					acc.addTransaction(acc.getEmail(), "System", rcAmount);
                    break;
				case 3:
					int zCoinAmount = rcAmount * 2;
					acc.withdrawRC(rcAmount);
					acc.setZCoinBalance(acc.getZCoinBalance() + zCoinAmount);
					acc.addTransaction("RC", "ZCoin", rcAmount);
					break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        } else {
            System.out.println("User not found.");
        }
    }
	
	public static void displayTransactionHistory(String zid, StoreDetails sd) {
    Account userAccount = sd.acc_map.get(zid);
    if (userAccount != null) {
        ArrayList<Transaction> transactionHistory = userAccount.getTransactionHistory();
        if (transactionHistory.isEmpty()) {
            System.out.println("Transaction history is empty.");
        } else {
            System.out.println("Transaction History:");
            for (Transaction transaction : transactionHistory) {
                System.out.println("From: " + transaction.from);
                System.out.println("To: " + transaction.to);
                System.out.println("Amount: " + transaction.amount);
                System.out.println("----------------------------");
            }
        }
    } else {
        System.out.println("User not found.");
    }
}

    
}

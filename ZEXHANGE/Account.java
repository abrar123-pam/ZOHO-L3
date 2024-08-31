import java.util.ArrayList;


public class Account {
    private String name;
    private String email;
    private String number;
    private String hid;
    private String password;
    private int realCoinDeposit;
	private int zCoinBalance; 
	ArrayList<Transaction> t_list;
	
    public Account(String name, String email, String number, String hid, String password, int realCoinDeposit, int zCoinBalance) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.hid = hid;
        this.password = password;
        this.realCoinDeposit = realCoinDeposit;
        this.zCoinBalance = zCoinBalance;
		this.t_list = new ArrayList<>();
    }
	
	public void addTransaction(String from, String to, int amount) {
        Transaction transaction = new Transaction(from, to, amount);
        t_list.add(transaction);
    }
	
	public ArrayList<Transaction> getTransactionHistory() {
        return t_list;
    }
	
	public void depositZCoin(int amount) {
        this.zCoinBalance += amount;
        System.out.println("ZCoin deposited successfully.");
    }

    public void withdrawZCoin(int amount) {
        if (amount <= zCoinBalance) {
            this.zCoinBalance -= amount;
            System.out.println("ZCoin withdrawn successfully");
        } else {
            System.out.println("Insufficient ZCoin balance");
        }
    }

	public void depositRC(int amount) {
        this.realCoinDeposit += amount;
        System.out.println("RC deposited successfully");
		System.out.println("Currently Your RC Amount is : "+realCoinDeposit);
    }

    public void withdrawRC(int amount) {
        if (amount <= realCoinDeposit) {
            this.realCoinDeposit -= amount;
            System.out.println("RC withdrawn successfully.");
			System.out.println("After Withdraw Your RC Amount is : "+realCoinDeposit);
        } else {
            System.out.println("Insufficient RC balance");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getHid() {
        return hid;
    }

    public String getPassword() {
        return password;
    }

    public int getRealCoinDeposit() {
        return realCoinDeposit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealCoinDeposit(int realCoinDeposit) {
        this.realCoinDeposit = realCoinDeposit;
    }
	
	public int getZCoinBalance() {
        return zCoinBalance;
    }

    public void setZCoinBalance(int zCoinBalance) {
        this.zCoinBalance = zCoinBalance;
    }
}

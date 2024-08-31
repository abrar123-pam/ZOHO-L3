import java.util.*;

class Bank{
	int total = 100;
	
	synchronized void withDraw(String name, int amount){
		
		if(amount <= total){
			System.out.println(name+" has withdrawn "+amount);
			total -= amount;
			System.out.println("Balance is : "+total);
			
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}else{
			System.out.println(name+" you cannot withdraw "+amount+" your balance is: "+total);
			
			try{
				Thread.sleep(2000);
			}catch(InterruptedException e){
				System.out.println(e.getMessage());
			}
		}
	}
	
	 synchronized void deposit(String name, int amount){
		total += amount;
		System.out.println(name+" deposited "+amount+" Balance after deposit: "+total);
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
				System.out.println(e.getMessage());
		}
	}
}


class withdrawThread extends Thread{
	
	Bank obj;
	String name;
	int amount;
	
	withdrawThread(Bank obj,String name, int amount){
		this.obj = obj;
		this.name = name;
		this.amount = amount;
	}
	
	public void run(){
		obj.withDraw(name,amount);
	}
}

class depositThread extends Thread{
	
	Bank obj;
	String name;
	int amount;
	
	depositThread(Bank obj,String name, int amount){
		this.obj = obj;
		this.name = name;
		this.amount = amount;
	}
	
	public void run(){
		obj.deposit(name,amount);
	}
}


class Main2{
	public static void main(String[] args){
		Bank bank = new Bank();
		
		
		withdrawThread t1 = new withdrawThread(bank,"Arnab",20);
		withdrawThread t2 = new withdrawThread(bank,"Monodwip",40);
		depositThread t3 = new depositThread(bank,"Mukta",35);
		withdrawThread t4 = new withdrawThread(bank,"Rinkel",80);
		withdrawThread t5 = new withdrawThread(bank,"Shubham",40);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
		
		
	/*	bank.withDraw("Arnab",20);
		bank.withDraw("Monodwip",40);
		bank.deposit("Mukta",35);
		bank.withDraw("Rinkel",80);
		bank.withDraw("Shubham",40);*/
		
	}
}
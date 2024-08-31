import java.util.*;

class Signal implements Runnable{
	String color;
	Thread thread;
	
	Signal(String color){
		this.color = color;
		thread = new Thread(this,color);
		
		thread.start();
	}
	
	public void run(){
		
		try{
			//for(int j=5;j>0;j--){
				System.out.println("SIGNAL IS -> " +color);
				System.out.println("Wait for timing");
				//new Thread(){
				//	for(int i=30;i>=0;i--){
				//	System.out.println(i);
				//	}
				//}
				Thread.sleep(2000);
			
		}catch(InterruptedException e){
			System.out.println("---------Thread Interupted---------");
		}
	}
}
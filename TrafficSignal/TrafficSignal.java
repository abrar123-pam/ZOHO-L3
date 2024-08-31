import java.util.*;

class TrafficSignal{
	
	private static void sleepInSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.println("Thread Interrupted");
        }
	}
	
	public static void main(String[] args){
		Signal s = new Signal("RED");
		sleepInSeconds(4);
		Signal s1 = new Signal("YELLOW");
		sleepInSeconds(5);
		Signal s2 = new Signal("Green");
    }
}
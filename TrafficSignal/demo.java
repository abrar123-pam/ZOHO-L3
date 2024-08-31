import java.util.concurrent.TimeUnit;

// Enum to represent the colors of the traffic signal
enum TrafficColor {
    RED, YELLOW, GREEN
}

// demoo class representing a single traffic signal
class demoo implements Runnable {
    private TrafficColor color;

    public demoo() {
        this.color = TrafficColor.RED; // Initial color is RED
    }

    // Method to change the color of the traffic signal
    public synchronized void changeColor() {
        switch (color) {
            case RED:
                color = TrafficColor.GREEN;
                break;
            case YELLOW:
                color = TrafficColor.RED;
                break;
            case GREEN:
                color = TrafficColor.YELLOW;
                break;
        }
        System.out.println("Signal changed to " + color);
        notify(); // Notify waiting threads that the color has changed
    }

    // Method to wait for a specified duration before changing the color
    private synchronized void waitForDuration(int duration) throws InterruptedException {
        TimeUnit.SECONDS.sleep(duration);
    }

    @Override
    public void run() {
        while (true) {
            try {
                // Display the current color of the traffic signal
                System.out.println("Signal is " + color);
                
                // Change the color based on the current color
                switch (color) {
                    case RED:
                        waitForDuration(5); // Wait for 5 seconds at RED
                        break;
                    case YELLOW:
                        waitForDuration(2); // Wait for 2 seconds at YELLOW
                        break;
                    case GREEN:
                        waitForDuration(3); // Wait for 3 seconds at GREEN
                        break;
                }
                
                // Change the color after waiting
                changeColor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Main class to start the traffic signal application
class demo {
    public static void main(String[] args) {
        // Create a new demoo object
        demoo signal = new demoo();
        
        // Create and start a new thread for the traffic signal
        Thread signalThread = new Thread(signal);
        signalThread.start();
    }
}

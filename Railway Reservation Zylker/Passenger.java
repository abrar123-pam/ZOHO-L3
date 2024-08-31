
class Passenger{

    String name;
    int age;
    String berth;
    String pnr;
    String allotted;
    int seatNumber;
    String bookingStatus;
    String currentStatus;
    boolean isChild;


    Passenger(String name,int age,String berth,String pnr,boolean isChild){
        this.name = name;
        this.age = age;
        this.berth = berth;
        this.allotted = "";
        this.seatNumber = -1;
        this.pnr = pnr;
        this.bookingStatus = "";
        this.currentStatus = "";
        this.isChild = isChild;

    }
	
	@Override
    public String toString() {
        return name + "," + age + "," + pnr;
    }

    public static Passenger fromString(String line) {
        String[] parts = line.split(",");
        if (parts.length < 3) {
            throw new IllegalArgumentException("Invalid input line: " + line);
        }
        String name = parts[0].trim();
        int age = Integer.parseInt(parts[1].trim());
        String pnr = parts[2].trim();

        return new Passenger(name, age, "", pnr, true);
    }
}
public class PassengerDetails {

    static int id = 1;
    String name;
    int age;
    String gender;
    String berth;
    int passengerId = id++;
    String allotted;
    int seatNumber;

    public PassengerDetails(String name, int age, String gender, String berth) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berth = berth;
        this.allotted = allotted;
        this.seatNumber = seatNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBerth() {
        return berth;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public String getAllotted() {
        return allotted;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBerth(String berth) {
        this.berth = berth;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public void setAllotted(String allotted) {
        this.allotted = allotted;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}

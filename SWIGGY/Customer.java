
public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String password;

    public Customer(String id, String name, String phoneNumber, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + phoneNumber + "," + password;
    }

    public static Customer fromString(String str) {
        String[] parts = str.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException("Invalid customer data: " + str);
        }
        return new Customer(parts[0], parts[1], parts[2], parts[3]);
    }
}
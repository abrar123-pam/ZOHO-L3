
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        loadData();

        boolean loop = true;

        while (loop) {
            System.out.println("1. Hotel Managers\n2. Customer\n3. Delivery Man\n4. Exit");
            int selectCategory = sc.nextInt();

            switch (selectCategory) {
                case 1:
                    handleHotelManagerOptions(sc);
                    break;
                case 2:
                    handleCustomerOptions(sc);
                    break;
                case 3:
                    handleDeliveryManOptions(sc);
                    break;
                case 4:
                    System.out.println("................Exitting................"  );
                    loop = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }

            saveData();
        }
    }

    private static void loadData() {
        files.loadHotels();
        files.loadCustomers();
        files.loadFoodItems();
    }

    private static void saveData() {
        files.saveHotels();
        files.saveCustomer();
        files.saveFoodItems();
    }

    private static void handleHotelManagerOptions(Scanner sc) {
        boolean hm = true;
        while (hm) {
            System.out.println("1. Register Hotel\n2. Login\n3. Exit");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("Shop Name: ");
                String sName = sc.next();
                System.out.println("Shop Owner Name: ");
                String sOwner = sc.next();
                System.out.println("Shop Address: ");
                String sAdd = sc.next();
                System.out.println("FSSAI Certificate number: ");
                String fNo = sc.next();
                System.out.println("Password (length 6): ");
                String pass = sc.next();
                if (pass.length() > 6) {
                    System.out.print("The Length exceeds");
                } else if (pass.length() < 6) {
                    System.out.print("The Length is lesser");
                } else {
                    Hotel hotel = new Hotel(sName, sOwner, sAdd, fNo, pass);
                    registerHotel(hotel);
                }
            } else if (choice == 2) {
                System.out.println("Enter shop name: ");
                String shopN = sc.next();
                System.out.println("Enter password: ");
                String shopP = sc.next();

                boolean isLogged = checkLoginDetails(shopN, shopP);
                if (isLogged) {
                    boolean log = true;
                    while (log) {
                        System.out.println("1. Add Food\n2. Current Orders\n3. Stock Analysis\n4. Exit");
                        int scff = sc.nextInt();

                        switch (scff) {
                            case 1:
                                addFood(shopN, sc);
                                break;
                            case 2:
                                currentOrders(shopN);
                                break;
                            case 3:
                                stockAnalysis(shopN);
                                break;
                            case 4:
                                log = false;
                                break;
                            default:
                                System.out.println("Enter valid choice");
                                break;
                        }
                    }
                } else {
                    System.out.println("Please enter valid details");
                }
            } else if (choice == 3) {
                hm = false;
            } else {
                System.out.println("Please enter valid choice");
            }
        }
    }

    private static void handleCustomerOptions(Scanner sc) {
        boolean cusCheck = true;

        while (cusCheck) {
            System.out.println("1. Register\n2. Login\n3. Exit");
            System.out.println("Enter choice: ");
            int cusChoice = sc.nextInt();
            if (cusChoice == 1) {
                System.out.println("Enter Name: ");
                String cusName = sc.next();

                System.out.println("Enter Phone Number: ");
                String cusNumber = sc.next();

                String cusPass;
                while (true) {
                    System.out.print("Enter Password (6 characters): ");
                    cusPass = sc.next();

                    if (cusPass.length() < 6) {
                        System.out.println("Password is too short. Please enter a 6-character password.");
                    } else if (cusPass.length() > 6) {
                        System.out.println("Password is too long. Please enter a 6-character password.");
                    } else {
                        break;
                    }
                }

                UniqueIDGenerator uidGen = new UniqueIDGenerator();
                String uniqueId = uidGen.generateUniqueID(8); // Assuming 8 character unique ID
                Customer customer = new Customer(uniqueId, cusName, cusNumber, cusPass);
                registerCustomer(customer);
            } else if (cusChoice == 2) {
                System.out.println("Enter your uniqueId: ");
                String uid = sc.next();
                System.out.println("Enter Password: ");
                String cusPass = sc.next();

                boolean isCustomerLogged = checkCustomerCredentails(uid, cusPass);

                if (isCustomerLogged) {
                    displayFood();
                    System.out.print("Enter shop name: ");
                    String shopName = sc.next();
                    System.out.print("Enter food item name: ");
                    String itemName = sc.next();
                    System.out.print("Enter quantity: ");
                    int quantity = sc.nextInt();

                    bookFood(shopName, itemName, quantity);
                } else {
                    System.out.println("Enter valid credentials");
                }
            } else if (cusChoice == 3) {
                cusCheck = false;
            } else {
                System.out.println("Please Enter Valid choice");
            }
        }
    }

    private static void handleDeliveryManOptions(Scanner sc) {
        boolean dmcheck = true;

        while (dmcheck) {
            System.out.println("1. Register Delivery Boy\n2. Check Rating\n3. Exit");
            int dm = sc.nextInt();

            switch (dm) {
                case 1:
                    System.out.println("Enter name:");
                    String dname = sc.next();
                    System.out.println("Enter phone Number:");
                    String dpn = sc.next();
                    System.out.println("Enter address:");
                    String dadd = sc.next();
                    System.out.println("Enter Bike Number:");
                    String dbnum = sc.next();
                    System.out.println("Enter License number:");
                    String dlic = sc.next();
                    Delivery d = new Delivery(dname, dpn, dadd, dbnum, dlic);
                    registerDeliveryBoy(d);
                    break;
                case 2:
                    // Add functionality for checking rating
                    break;
                case 3:
                    dmcheck = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }

    private static void bookFood(String shopName, String itemName, int quantity) {
        Register rbf = new Register();

        if (!Register.stored_hotel.containsKey(shopName)) {
            System.out.println("Not able to find the Shop");
        } else {
            rbf.bookFood(shopName, itemName, quantity);
        }
    }

    private static void displayFood() {
        Register rd = new Register();
        rd.displayFood();
    }

    private static boolean checkCustomerCredentails(String uid, String cusPass) {
        Register rcc = new Register();

        if (!Register.stored_customer.containsKey(uid)) {
            System.out.println("Enter valid customer id");
        }

        return rcc.checkCustomer(uid, cusPass);
    }

    private static void registerCustomer(Customer customer) {
        Register rc = new Register();
        rc.registerCustomer(customer.getId(), customer);
    }

    public static void registerDeliveryBoy(Delivery d) {
        Register rd = new Register();
        rd.registerDeliveryBoy(d);
    }

    public static void registerHotel(Hotel h) {
        Register r = new Register();
        r.registerHotels(h);
    }

    public static boolean checkLoginDetails(String hName, String hPass) {
        Register r = new Register();
        return r.checkLogin(hName, hPass);
    }

    public static void addFood(String shopName, Scanner sc) {
        System.out.print("Enter food item name: ");
        String itemName = sc.next();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        System.out.print("Enter price: ");
        int price = sc.nextInt();
        Register.addFoodItem(shopName, itemName, quantity, price);
    }

    public static void currentOrders(String shopName) {
        Map<String, FoodItem> currentOrders = Register.getCurrentOrders(shopName);
        System.out.println("Current Orders for " + shopName + ":");
        for (Map.Entry<String, FoodItem> entry : currentOrders.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void stockAnalysis(String shopName) {
        Register.stockAnalysis(shopName);
    }
}
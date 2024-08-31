
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

//import static Register.stored_customer;
//import static Register.stored_hotel;

public class files {
    private static final String HOTEL_FILE = "C:\\Users\\inc5540-37\\Desktop\\L3\\SWIGGY\\hotels.txt";

    private static final String FOOD_FILE = "C:\\Users\\inc5540-37\\Desktop\\L3\\SWIGGY\\foods.txt";

    private static final String CUSTOMER_FILE = "C:\\Users\\inc5540-37\\Desktop\\L3\\SWIGGY\\customer.txt";


    public static void saveCustomer(){
        try(FileWriter writer = new FileWriter(CUSTOMER_FILE)) {
            for (Customer customer : Register.stored_customer.values()) {
                writer.write(customer.toString() + "\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void loadCustomers() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CUSTOMER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Customer customer = Customer.fromString(line);
                Register.stored_customer.put(customer.getId(), customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void saveFoodItems(){
        try(FileWriter writer = new FileWriter(FOOD_FILE)){
            for(Hotel hotel : Register.stored_hotel.values()){
                for(Map.Entry<String,FoodItem> entry : hotel.getFoodInventory().entrySet()){
                    writer.write(hotel.getShopName() +","+entry.getKey()+","+entry.getValue().getQuantity()+","+entry.getValue().getPrice()+"\n");
                }
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void loadFoodItems(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FOOD_FILE))) {

            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(",",4);
                String shopName = parts[0];
                String itemName = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                int price = Integer.parseInt(parts[3]);
                Hotel hotel = Register.stored_hotel.get(shopName);
                if(hotel != null){
                    hotel.addFoodItems(itemName,quantity,price);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public static void saveHotels() {
        try (FileWriter writer = new FileWriter(HOTEL_FILE)) {
            for (Hotel hotel : Register.stored_hotel.values()) {
                writer.write(hotel.toString() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadHotels() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HOTEL_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Hotel hotel = Hotel.fromString(line);
                Register.stored_hotel.put(hotel.getShopName(), hotel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
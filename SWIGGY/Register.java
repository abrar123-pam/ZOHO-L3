
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Register{
    static Map<String,Hotel> stored_hotel = new HashMap<>();
    static Map<String,Delivery> stored_delivery = new HashMap<>();
    static Map<String,Customer> stored_customer = new HashMap<>();

    public void registerCustomer(String uniqueId,Customer customer){
        stored_customer.put(uniqueId,customer);
        System.out.println("******************************************");
        System.out.println("Customer Register Successfully");
        System.out.println("Your Unique Id is : "+uniqueId);
        System.out.println("******************************************");
    }

    public void bookFood(String sName, String food,int quantity){
        Hotel hotel = stored_hotel.get(sName);

        if(hotel != null){
            Map<String,FoodItem> foodInventory = hotel.getFoodInventory();
            if(foodInventory.containsKey(food)){
                FoodItem item = foodInventory.get(food);
                if(item.getQuantity() >= quantity){
                    int remainingQuantity = item.getQuantity() - quantity;
                    item.setQuantity(remainingQuantity);

                    int price = item.getPrice();
                    double taxRate = 0.10;
                    double totalPrice = price * quantity;
                    double tax = totalPrice * taxRate;
                    double totalBill = totalPrice +tax;


                    System.out.println("******************************************");
                    System.out.println("Order Summary");
                    System.out.println("Hotel: " + sName);
                    System.out.println("Food Item: " + food);
                    System.out.println("Quantity: " + quantity);
                    System.out.println("Price per item: " + price);
                    System.out.println("Total Price: " + totalPrice);
                    System.out.println("Tax (10%): " + tax);
                    System.out.println("Total Bill: " + totalBill);
                    System.out.println("******************************************");
                }else{
                    System.out.println("Insufficient quantity available for " + food + ". Available: " + item.getQuantity());
                }
            }else {
                System.out.println("Food item " + food + " is not available in " + sName);
            }
        }else {
            System.out.println("Shop not found");
        }
    }

    public boolean checkCustomer(String uid, String pass){
        Customer customer = stored_customer.get(uid);

        if(customer.getPassword().equals(pass)){
            return true;
        }
        return false;
    }


    public void registerDeliveryBoy(Delivery d){
        stored_delivery.put(d.getLicenseNumber(),d);
        System.out.println("Registerd Succsessfully");
    }


    public void registerHotels(Hotel h){
        stored_hotel.put(h.getShopName(),h);
        System.out.println("Hotel Registerd Succsessfully");
    }

    public boolean checkLogin(String hotelName, String pass){
        for (Hotel h : stored_hotel.values()) {
            if (h.getShopName().equals(hotelName) && h.getPassword().equals(pass)) {
                return true;
            }
        }
        return false;
    }

    public static void addFoodItem(String shopName, String itemName, int quantity,int price) {
        Hotel hotel = stored_hotel.get(shopName);
        if (hotel != null) {
            hotel.addFoodItems(itemName, quantity,price);
            System.out.println("Food item added successfully.");
        } else {
            System.out.println("Shop not found.");
        }
    }

    public static Map<String, FoodItem> getCurrentOrders(String shopName) {
        Hotel hotel = stored_hotel.get(shopName);
        if (hotel != null) {
            return hotel.getCurrentOrders();
        } else {
            System.out.println("Shop not found.");
            return new HashMap<>();
        }
    }

    public static void stockAnalysis(String shopName) {
        Hotel hotel = stored_hotel.get(shopName);
        if (hotel != null) {
            hotel.analyzeStock();
        } else {
            System.out.println("Shop not found.");
        }
    }

    public void displayFood() {
        if (stored_hotel.isEmpty()) {
            System.out.println("No hotels are registered.");
        } else {
            for (Hotel h : stored_hotel.values()) {
                System.out.println("--------------- " + h.getShopName() + " ---------------");
                if (h.getFoodInventory().isEmpty()) {
                    System.out.println("No food items available.");
                } else {
                    for (Map.Entry<String, FoodItem> entry : h.getFoodInventory().entrySet()) {
                        String itemName = entry.getKey();
                        FoodItem item = entry.getValue();
                        int quantity = item.getQuantity();
                        int price = item.getPrice();
                        System.out.println(itemName + ": Quantity - " + quantity + ", Price - " + price);
                    }
                }
                System.out.println("------------------------------------------");
            }
        }
    }

}
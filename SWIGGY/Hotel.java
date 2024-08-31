
import java.util.HashMap;
import java.util.Map;

class Hotel{
    // static int id = 1;
    private String shopName;
    private String ownerName;
    private String shopAddress;
    private String fssaiCertificate;
    private String password;
    private Map<String, FoodItem> foodInventory;
    //  int hotelId = id++;

    Hotel(String shopName, String ownerName, String shopAddress, String fssaiCertificate, String password) {
        this.shopName = shopName;
        this.ownerName = ownerName;
        this.shopAddress = shopAddress;
        this.fssaiCertificate = fssaiCertificate;
        this.password = password;
        this.foodInventory = new HashMap<>();
    }

    public String getShopName() {
        return shopName;
    }

    public String getPassword() {
        return password;
    }

    public void addFoodItems(String itemName, int quantity,int price) {
        FoodItem foodItem = new FoodItem(quantity, price);
        foodInventory.put(itemName, foodItem);    }

    public Map<String, FoodItem> getCurrentOrders() {
        return foodInventory;
    }

    public Map<String, FoodItem> getFoodInventory() {
        return foodInventory;
    }

    public void analyzeStock() {
        System.out.println("Stock Analysis for " + shopName + ":");
        for (Map.Entry<String, FoodItem> entry : foodInventory.entrySet()) {
            String itemName = entry.getKey();
            FoodItem item = entry.getValue();
            int quantity = item.getQuantity();
            int price = item.getPrice();
            System.out.println(itemName + ": Quantity - " + quantity + ", Price - " + price);
        }
    }

    @Override
    public String toString() {
        return shopName + "," + ownerName + "," + shopAddress + "," + fssaiCertificate + "," + password;
    }

    public static Hotel fromString(String line) {
        String[] parts = line.split(",");
        return new Hotel(parts[0], parts[1], parts[2], parts[3], parts[4]);
    }
}
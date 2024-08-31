
import java.util.*;

class User {
    private String name;
    private String phoneNumber;
    private String email;
    private String password;
    private List<Product> wishlist;
    private List<Product> orders;

    public User(String name, String phoneNumber, String email, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        this.wishlist = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Product> getWishlist() {
        return wishlist;
    }

    public List<Product> getOrders() {
        return orders;
    }

    public void addToWishlist(Product product) {
        wishlist.add(product);
    }

    public void orderItem(Product product) {
        orders.add(product);
    }
}

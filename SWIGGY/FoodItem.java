
class FoodItem {
    private int quantity;
    private int price;

    public FoodItem(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
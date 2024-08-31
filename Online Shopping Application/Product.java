class Product {

    static int id = 1;
    private String productName;
    private int productQuantity;
    private int productPrice; 
    private int productId;
    private String category;

    Product(String productName, int productQuantity, int productPrice, String category) { // Corrected variable name
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.productId = id;
        this.category = category;
        id = id + 1;
    }

    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductId() {
        return productId;
    }
}

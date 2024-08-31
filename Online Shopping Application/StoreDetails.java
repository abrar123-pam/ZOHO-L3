import java.util.*;

class StoreDetails {

    Map<Integer, Product> product_map = new HashMap<>();
	Map<String, User> user_map = new HashMap<>();

    public void addProduct(Product p) {
        int id = p.getProductId();
        product_map.put(id, p);
        System.out.println("Product added successfully");
    }

    public void generateCouponCode(int id, int amt) {

        if (!product_map.containsKey(id)) {
            System.out.println("There is no product exist in this id " + id);
        }

        Product p = product_map.get(id);

        if (amt > p.getProductPrice()) {
            System.out.println("Your " + p.getProductName() + " price is " + p.getProductPrice() + " and amount is greater not able to generate coupon code");
        } else {
            p.setProductPrice(p.getProductPrice() - amt);
            UniqueIDGenerator uidGen = new UniqueIDGenerator();
            String uniqueId = uidGen.generateUniqueID(6);
            System.out.println(uniqueId);
        }
    }
	
	public void checkStocks(int id){
		if (!product_map.containsKey(id)) {
            System.out.println("There is no product exist in this id " + id);
        }
		
		Product p = product_map.get(id);
		
		System.out.println("Product name "+p.getProductName()+" Available Stocks id :" + p.getProductQuantity());
	}
	
	public void addNewUser(String name ,User user){
		user_map.put(name,user);
	}
	
	public static boolean validUser(String name , String passs){
		if(!user_map.containsKey(name)){
			return false;
		}
		User u = user_map.get(name);
		
		if(u.getName().equals(name) && u.getPassword().equals(passs)){
			return true;
		}
		
		return false;
	}
}


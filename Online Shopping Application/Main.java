import java.util.*;

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		StoreDetails sd = new StoreDetails();
		
		while(loop){
			System.out.println("1. Admin\n2. User\n3. Exit");
			System.out.println("Enter your choice : ");
			int choice = sc.nextInt();
			
			switch(choice){
				case 1:
					admin(sc,sd);
					break;
				case 2:
					user(sc,sd);
					break;
				case 3:
				loop = false;
					break;
				default:
					System.out.println("Enter valid choice");
					break;
			}
		}
	}
	
	public static void admin(Scanner sc,StoreDetails sd){
		System.out.print("Enter name : ");
		String a_name = sc.next();
		
		System.out.print("Enter pass : ");
		String a_pass = sc.next();
		
		if(a_name.equals("john") && a_pass.equals("111222")|| a_name.equals("mark") && a_pass.equals("222111")){
			boolean adminLoop = true;
			
			while(adminLoop){
				System.out.println("1. Add Products\n2. Coupon code\n3. Shopping History\n4. Check Stocks\n5. Exit");
				System.out.print("Enter your choice : ");
				int a_choice = sc.nextInt();
				
				switch(a_choice){
					
					case 1:
						addProducts(sc,sd);
						break;
					case 2:
						generateCoupon(sc,sd);
						break;
					case 3:
						break;
					case 4:
						checkQuantities(sc,sd);
						break;
					case 5:
						adminLoop = false;
						break;
					default:
						System.out.println("Enter valid choice");
						break;
				}
			}
		}else{
			System.out.println("Invalid User");
		}	
	}
	
	public static void addProducts(Scanner sc,StoreDetails sd){
		
		boolean addLoop = true;
		
		while(addLoop){
			System.out.println("Enter name of the Product");
			String p_name = sc.next();
			
			System.out.println("Enter quantity of the Product");
			int p_quantity = sc.nextInt();
			
			System.out.println("Enter product price : ");
			int p_price = sc.nextInt();
			
			System.out.println("Enter Cateogory");
			String p_cat = sc.next();
			
			Product p = new Product(p_name,p_quantity,p_price,p_cat);
			
			
			sd.addProduct(p);
			
			System.out.println("---------------do you want to add more products------------------");
			char ch = sc.next().charAt(0);
			if(ch == 'N' || ch == 'n'){
				addLoop = false;
			}
			
		}	
	}
	
	public static void generateCoupon(Scanner sc,StoreDetails sd){
		System.out.println("Enter productId : ");
		int id = sc.nextInt();
		
		System.out.println("Enter how many amount you want to discount for the product");
		int amt = sc.nextInt();
		
		sd.generateCouponCode(id, amt);
	}
	
	public static void checkQuantities(Scanner sc , StoreDetails sd){
		System.out.println("Enter productId : ");
		int q_id = sc.nextInt();
		
		sd.checkStocks(q_id);
	}
	
	public static void user(Scanner sc , StoreDetails sd){
		boolean userLoop = true;
		
		while(userLoop){
			System.out.println("1. Create New Account\n2. Login\n3. Exit");
			int userChoice = sc.nextInt();
			
			switch(userChoice){
				case 1:
					createNewUser(sc,sd);
					break;
				case 2:
					login(sc,sd);
					break;
				case 3:
					userLoop = false;
					break;
				default:
					break;
			}
		}
		
		
	}

	public static void createNewUser(Scanner sc , StoreDetails sd){
		
		System.out.println("Enter name : ");
		String u_name = sc.next();
		
		System.out.println("Enter phone Number : ");
		String u_number = sc.next();
		
		System.out.println("Enter Email");
		String u_mail = sc.next();
		
		System.out.println("Enter password");
		String u_pass = sc.next();
		
		User user = new User(u_name,u_number,u_mail,u_pass);
		sd.addNewUser(u_name,user);
	}
	
	public static boolean isValidUser(String name, String pass,StoreDetails sd){
		return sd.validUser(name,pass);
	}
	
	public static void login(Scanner sc, StoreDetails sd){
		System.out.print("Enter name : ");
		String user_name = sc.next();
		System.out.print("Enter Password : ");
		String user_pass = sc.next();
		
		if(!isValidUser(user_name,user_pass,sd)){
			System.out.println("Invalid user id and password ");
		}else{
			showOthersDetails(sc,sd);
		}
	}
	
	public static void showOthersDetails(Scanner sc, StoreDetails sd){
		boolean seeLoop =true;
		
		while(seeLoop){
			
			System.out.println("1. List of Products\n2. Search Product\n3. WishList\n4. Orders\n5. Cancel Order\6. Payment\n7. Exit");
			int s_choice = sc.nextInt();
			
			switch(s_choice){
				case 1:
				listProducts(sd);
					break;
				case 2:
					searchProduct(sc,sd);
					break;
				case 3:
					addToWishlist(sc, sd, user);
					break;
				case 4:
					orderItem(sc, sd, user);
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					seeLoop = false;
					break;
				default : 
					break;
					
					
			}
		}
	}
	
	public static void listProducts(StoreDetails sd) {
		Map<Integer, Product> productMap = sd.product_map;

		if (productMap.isEmpty()) {
			System.out.println("No products available.");
		} else {
			System.out.println("List of Products:");
			for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
				Product product = entry.getValue();
				System.out.println("Product ID: " + product.getProductId());
				System.out.println("Name: " + product.getProductName());
				System.out.println("Quantity: " + product.getProductQuantity());
				System.out.println("Price: " + product.getProductPrice());
				System.out.println("Category: " + product.getCategory());
				System.out.println("---------------------------------");
			}
		}
	}
	
	

	public static void searchProduct(Scanner sc, StoreDetails sd) {
		System.out.println("Enter product name to search: ");
		String productName = sc.next();

		boolean found = false;
		for (Map.Entry<Integer, Product> entry : sd.product_map.entrySet()) {
			Product product = entry.getValue();
			if (product.getProductName().equalsIgnoreCase(productName)) {
				System.out.println("Product Found:");
				System.out.println("Product ID: " + product.getProductId());
				System.out.println("Name: " + product.getProductName());
				System.out.println("Quantity: " + product.getProductQuantity());
				System.out.println("Price: " + product.getProductPrice());
				System.out.println("Category: " + product.getCategory());
				found = true;
				break;
			}
		}

		if (!found) {
			System.out.println("Product not found.");
		}
	}
	
	public static void addToWishlist(Scanner sc, StoreDetails sd, User user) {
		System.out.println("Enter product ID to add to wishlist: ");
		int productId = sc.nextInt();

		if (sd.product_map.containsKey(productId)) {
			Product product = sd.product_map.get(productId);
			user.addToWishlist(product);
			System.out.println("Product added to wishlist successfully.");
		} else {
			System.out.println("Product not found.");
		}
	}
	
	public static void orderItem(Scanner sc, StoreDetails sd, User user) {
		System.out.println("Enter product ID to order: ");
		int productId = sc.nextInt();

		if (sd.product_map.containsKey(productId)) {
			Product product = sd.product_map.get(productId);
			user.orderItem(product);
			System.out.println("Item ordered successfully.");
		} else {
			System.out.println("Product not found.");
		}
	}
}
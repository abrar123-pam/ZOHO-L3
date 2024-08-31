import java.util.*;

class Helper{
	
	Map<String,User> user_map = new HashMap<>();
	static Map<String, List<User>> tollDetails = new HashMap<>();
	
	public void addUser(String vname,User user){
		user_map.put(vname,user);
	}
	
	

    public void updateTollDetails(String toll, User user) {
        if (!tollDetails.containsKey(toll)) {
            tollDetails.put(toll, new ArrayList<>());
        }
        tollDetails.get(toll).add(user);
    }

    
	
}
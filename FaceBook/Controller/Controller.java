package FaceBook.Controller;

import FaceBook.Database.database;
import FaceBook.Models.Post;
import FaceBook.Models.User;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    database db = database.load();

    public void addUser(User user) {
        db.user_list.add(user);
    }

    public boolean isValidEmail(String email) {
        String pattern  = "^[a-zA-Z0-9+-.]+@[a-zA-Z0-9]+\\.(com|in)";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(email);
        return matcher.matches();
    }

    public boolean isValidUser(String username,String password) {

        for(User user : db.user_list) {
            if(user.getName().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean AddPost(Post post,String name) {
        for(User user : db.user_list) {
            if(user.getName().equals(name)) {
                user.getPosts().add(post);
                return true;
            }
        }
        return false;
    }

    public void displayPost(String name) {
        for(User user : db.user_list) {
            if(user.getName().equals(name)) {
                for(Post post : user.getPosts()) {
                    System.out.println("-------------------------------------");
                    System.out.println(post.getSub());
                    System.out.println(post.getDescription());
                    System.out.println("-------------------------------------");
                }
            }
        }
    }

    public boolean deletePost(String title,String name) {
        for (User user : db.user_list) {
            if(user.getName().equals(name)) {
                for (Post post : user.getPosts()) {
                    if(post.getSub().equals(title)) {
                        user.getPosts().remove(post);
                        return true;
                    }
                }

            }
        }
        return false;
    }
}

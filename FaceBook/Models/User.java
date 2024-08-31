package FaceBook.Models;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String name;
    private String email;
    private String password;
    private ArrayList<Post> posts;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        posts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

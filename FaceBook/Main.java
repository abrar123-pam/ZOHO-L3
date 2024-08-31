package FaceBook;

import FaceBook.Controller.Controller;
import FaceBook.Models.Post;
import FaceBook.Models.User;
import java.util.Scanner;
import FaceBook.Database.*;


public class Main {
    private static database db;

    public static void main(String[] args) {
        Controller controller = new Controller();

        Scanner sc = new Scanner(System.in);
        db = database.load();
        boolean loop = true;

        while (loop){

            System.out.println("1. Create Account\n2. Login\n3. Exit");

            System.out.print( "Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    signup(controller,sc);
                    break;
                case 2:
                    login(controller,sc);
                    break;
                case 3:
                    loop = false;
                    System.out.println("--------Exitting---------");
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }

        db.save();
    }

    private static void signup(Controller controller,Scanner sc) {

        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your email: ");
        String email = sc.next();

        if(controller.isValidEmail(email)){
            System.out.println("Enter your password: ");
            String password = sc.next();

            User user = new User(name, email, password);
            controller.addUser(user);
        }else{
            System.out.println("Please Enter valid email ");
        }
    }

    private static void login(Controller controller,Scanner sc) {

        System.out.println("Enter your name: ");
        String name = sc.next();
        System.out.println("Enter your password : ");
        String password = sc.next();

        if(controller.isValidUser(name,password)){
            System.out.println("You have successfully logged in");
            displayHomePage(controller,sc,name);
        }else{
            System.out.println("Username or password is incorrect");
        }
    }

    private static void displayHomePage(Controller controller, Scanner sc, String name) {
        System.out.println("Welcome to FaceBook");
        int homeChoice;

        boolean homeLoop = true;
        while (homeLoop) {
            System.out.println("1. Create Post\n2. Get News Feed\n3. Follow/Unfollow\n4. Delete Post\n5. Exit");
            System.out.print("Enter your choice: ");
            homeChoice = sc.nextInt();

            switch (homeChoice) {
                case 1:
                    createPost(controller, sc, name);
                    break;
                case 2:
                    getNewsFeed();
                    break;
                case 3:
                    followOrUnfollow();
                    break;
                case 4:
                    deletePost(controller, sc, name);
                    break;
                case 5:
                    homeLoop = false;
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        }
    }


    private static void followOrUnfollow() {
        System.out.println("Follow method");
    }

    private static void getNewsFeed() {
        System.out.println("Unfollow method");
    }

    private static void deletePost(Controller controller, Scanner sc, String name) {
        System.out.println("These Are Your Posts");
        controller.displayPost(name);
        System.out.println("Enter title name which you want to delete: ");
        String title = sc.next();
        if(controller.deletePost(title,name)){
            System.out.println("Post deleted successfully");
        }else{
            System.out.println("Post could not be deleted");
        }
    }

    private static void createPost(Controller controller, Scanner sc, String name) {
        boolean createAnother = true;
        while (createAnother) {
            System.out.println("Enter the post title: ");
            String title = sc.next();
            System.out.println("Enter the post Description: ");
            String description = sc.next();

            Post post = new Post(title, description);
            if (controller.AddPost(post, name)) {
                System.out.println("Post created successfully");
            } else {
                System.out.println("Post creation failed");
            }

            System.out.print("Do you want to create another post? (yes/no): ");
            String response = sc.next().toLowerCase();
            if (!response.equals("yes")) {
                createAnother = false;
            }
        }
    }

}

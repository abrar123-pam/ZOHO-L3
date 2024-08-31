package FaceBook.Database;

import FaceBook.Models.User;

import java.io.*;
import java.util.ArrayList;

public class database implements Serializable {

    public ArrayList<User> user_list  = new ArrayList<>();

    private static database instance = null;

    private static String path = "C:\\Users\\inc5540-37\\Desktop\\L3\\FaceBook\\db.txt";
    private final static long serialVersionUID = 1L;

    public void save(){
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this);
            System.out.println("Database saved to " + path);
            System.out.println("Database Saved Successfully");
            oos.close();
            fos.close();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static database load(){
        if(instance != null) return instance;

        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            instance = (database) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Database loaded from " + path);
            System.out.println("Database Loaded Successfully");
        }catch (Exception e){
            instance = new database();
            System.out.println(e.getMessage());
        }

        return instance;
    }
}

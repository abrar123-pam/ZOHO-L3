package problems.BookMyShow.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    static {
        try {
            // Register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/movie_booking";
        String user = "root"; // Your MySQL username
        String password = "Pamranger1#"; // Your MySQL password
        return DriverManager.getConnection(url, user, password);
    }
}

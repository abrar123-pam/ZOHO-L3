package problems.BookMyShow.DataBase;

import problems.BookMyShow.Theater.Theater;

import java.sql.*;

public class TheaterDAO {

    public void addTheater(Theater theater) {
        String query = "INSERT INTO theaters (theater_name, theater_address) VALUES (?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, theater.getTheaterName());
            pstmt.setString(2, theater.getTheaterAddress());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Theater getTheater(String theaterName) {
        String query = "SELECT * FROM theaters WHERE theater_name = ?";
        Theater theater = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, theaterName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    theater = new Theater(
                            rs.getString("theater_name"),
                            rs.getString("theater_address")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return theater;
    }

}


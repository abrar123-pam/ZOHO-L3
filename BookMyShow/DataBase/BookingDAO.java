package problems.BookMyShow.DataBase;

import problems.BookMyShow.Booking.Booking;
import problems.BookMyShow.Movies.Movies;
import problems.BookMyShow.Theater.Theater;

import java.sql.*;
import java.util.*;
import java.util.stream.Collectors;

public class BookingDAO {

    public void addBooking(Booking booking) {
        String query = "INSERT INTO bookings (movie_title, total_cost, theater_name, screen_number, seat_numbers) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, booking.getMovie().getTitle()); // Assuming Movies has getTitle()
            pstmt.setInt(2, booking.getTotalCost());
            pstmt.setString(3, booking.getTheater().getTheaterName());
            pstmt.setInt(4, booking.getScreenNumber());

            // Convert List<String> to comma-separated String
            String seatNumbersStr = String.join(",", booking.getSeatNumbers());
            pstmt.setString(5, seatNumbersStr);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Booking getBookingById(int id) {
        String query = "SELECT * FROM bookings WHERE id = ?";
        Booking booking = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String seatNumbersStr = rs.getString("seat_numbers");
                    // Convert comma-separated String to List<String>
                    List<String> seatNumbers = Arrays.asList(seatNumbersStr.split(","));

                    // Assuming you have a way to get Movies and Theater objects by their names
                    Movies movie = getMovieByTitle(rs.getString("movie_title"));
                    Theater theater = getTheaterByName(rs.getString("theater_name"));

                    booking = new Booking(
                            movie,
                            rs.getInt("total_cost"),
                            theater,
                            rs.getInt("screen_number"),
                            seatNumbers
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return booking;
    }

    // Placeholder methods to get Movies and Theater objects
    private Movies getMovieByTitle(String title) {
        // Implement logic to retrieve movie by title
        return null;
    }

    private Theater getTheaterByName(String name) {
        // Implement logic to retrieve theater by name
        return null;
    }
}

package problems.BookMyShow.DataBase;

import problems.BookMyShow.Movies.Movies;

import java.sql.*;

public class MoviesDAO {

    public void addMovie(Movies movie) {
        String query = "INSERT INTO movies (title, description, duration, language) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDescription());
            pstmt.setDouble(3, movie.getDuration());
            pstmt.setString(4, movie.getLang());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Movies getMovie(String title) {
        String query = "SELECT * FROM movies WHERE title = ?";
        Movies movie = null;

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, title);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    movie = new Movies(
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getDouble("duration"),
                            rs.getString("language")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    // Add methods to update, delete, and list movies as needed
}

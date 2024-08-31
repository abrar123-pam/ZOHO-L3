package problems.BookMyShow.Screens;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Screen implements Serializable {
    private int screenNumber;
    private int row;
    private int column;
    private int[][] seats;
    private Map<String, String> showtimes; // Map to store showtimes

    public Screen(int screenNumber, int row, int column) {
        this.screenNumber = screenNumber;
        this.row = row;
        this.column = column;
        seats = new int[row][column];
        showtimes = new HashMap<>();
        initializeSeats();
    }

    private void initializeSeats() {
        int seatNumber = 1;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                seats[r][c] = seatNumber++;
            }
        }
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public void setScreenNumber(int screenNumber) {
        this.screenNumber = screenNumber;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int[][] getSeats() {
        return seats;
    }

    public void setSeats(int[][] seats) {
        this.seats = seats;
    }

    public Map<String, String> getShowtimes() {
        return showtimes;
    }

    public void addShowtime(String showtime, String movieTitle) {
        this.showtimes.put(showtime, movieTitle);
    }
}

package problems.BookMyShow.Booking;

import problems.BookMyShow.Movies.Movies;
import problems.BookMyShow.Theater.Theater;

import java.util.List;

public class Booking {
    private Movies movie;
    private int totalCost;
    private Theater theater;
    private int screenNumber;
    private List<String> seatNumbers;

    public Booking(Movies movie, int totalCost, Theater theater, int screenNumber, List<String> seatNumbers) {
        this.movie = movie;
        this.totalCost = totalCost;
        this.theater = theater;
        this.screenNumber = screenNumber;
        this.seatNumbers = seatNumbers;
    }

    public Movies getMovie() {
        return movie;
    }

    public String getMovieTitle() {
        return movie.getTitle(); // Assuming Movies class has a getTitle() method
    }

    public int getTotalCost() {
        return totalCost;
    }

    public Theater getTheater() {
        return theater;
    }

    public String getTheaterName() {
        return theater.getTheaterName(); // Assuming Theater class has a getName() method
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }
}

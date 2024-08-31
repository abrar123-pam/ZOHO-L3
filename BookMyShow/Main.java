package problems.BookMyShow;

import problems.BookMyShow.Controller.Controller;
import problems.BookMyShow.Booking.Booking;
import problems.BookMyShow.Movies.Movies;
import problems.BookMyShow.Theater.Theater;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();

        Theater theater = new Theater("INOX", "OMR Chennai");
        controller.addTheater(theater);
        System.out.println("Theater added: " + theater.getTheaterName());

        Movies movie = new Movies("Inception", "A mind-bending thriller", 148.0, "English");
        controller.addMovie(movie);
        System.out.println("Movie added: " + movie.getTitle());

        Movies movie2 = new Movies("The Goat", "Vijay", 2.15, "Tamil");
        controller.addMovie(movie2);
        System.out.println("Movie added: " + movie.getTitle());

        Booking booking = new Booking(
                movie,
                300,
                theater,
                1,
                Arrays.asList("A1", "A2", "A3")
        );
        controller.addBooking(booking);
        System.out.println("Booking added for movie: " + booking.getMovie().getTitle() +
                " at theater: " + booking.getTheater().getTheaterName() +
                " in screen number: " + booking.getScreenNumber());

        Theater retrievedTheater = controller.getTheater("INOX");
        if (retrievedTheater != null) {
            System.out.println("Retrieved Theater: " + retrievedTheater.getTheaterName() + ", Address: " + retrievedTheater.getTheaterAddress());
        }

        Movies retrievedMovie = controller.getMovie("Inception");
        if (retrievedMovie != null) {
            System.out.println("Retrieved Movie: " + retrievedMovie.getTitle() +
                    ", Description: " + retrievedMovie.getDescription() +
                    ", Duration: " + retrievedMovie.getDuration() +
                    ", Language: " + retrievedMovie.getLang());
        }
    }
}

package problems.BookMyShow.Controller;

import problems.BookMyShow.Booking.Booking;
import problems.BookMyShow.DataBase.BookingDAO;
import problems.BookMyShow.DataBase.MoviesDAO;
import problems.BookMyShow.DataBase.TheaterDAO;
import problems.BookMyShow.Movies.Movies;
import problems.BookMyShow.Screens.Screen;
import problems.BookMyShow.Theater.Theater;
import problems.BookMyShow.User.User;
import java.io.*;
import java.util.*;

public class Controller {
    private final TheaterDAO theaterDAO;
    private final MoviesDAO moviesDAO;
    private final BookingDAO bookingDAO;


    public Controller(){
        this.theaterDAO = new TheaterDAO();
        this.moviesDAO = new MoviesDAO();
        this.bookingDAO = new BookingDAO();
    }

    public void addMovie(Movies movie) {
        moviesDAO.addMovie(movie);
    }

    public Movies getMovie(String title) {
        return moviesDAO.getMovie(title);
    }

    public void addTheater(Theater theater) {
        theaterDAO.addTheater(theater);
    }

    public Theater getTheater(String theaterName) {
        return theaterDAO.getTheater(theaterName);
    }

    public void addBooking(Booking booking) {
        bookingDAO.addBooking(booking);
    }


//    public void removeTheater(String theaterName) {
//        if(theaters.containsKey(theaterName)){
//            theaters.remove(theaterName);
//        }else{
//            System.out.println("No such theater");
//        }
//    }
//    public  void addUser(User u) {
//        user.put(u.getUserId(),u);
//    }
//
//    public void displayTheaters() {
//        for(Theater theater : theaters.values()) {
//            System.out.println(theater.getTheaterName());
//        }
//        System.out.println();
//    }
//
//    public void linkMovieToTheater(String movieTitle, String theaterToLink) {
//        Movies movie = findMovieByTitle(movieTitle);
//        Theater theater = theaters.get(theaterToLink);
//
//        if (movie != null && theater != null) {
//            movie.addTheater(theater);
//            System.out.println("Movie " + movieTitle + " has been linked to Theater " + theaterToLink);
//        } else {
//            System.out.println("Movie or Theater not found.");
//        }
//    }
//
//    private Movies findMovieByTitle(String movieTitle) {
//        for (Movies movie : movies) {
//            if (movie.getTitle().equals(movieTitle)) {
//                return movie;
//            }
//        }
//        return null;
//    }
//
//    public void displayScreens(String theaterName) {
//        Theater theater = theaters.get(theaterName);
//        if (theater != null) {
//            for (Map.Entry<Integer, Screen> entry : theater.getScreenList().entrySet()) {
//                Screen screen = entry.getValue();
//                System.out.println("Screen Number: " + screen.getScreenNumber());
//            }
//        } else {
//            System.out.println("Theater not found.");
//        }
//    }
//
//    public void setShowtime(String theaterName, int screenNumber, String showtime, String MovieTitle) {
//        Theater theater = theaters.get(theaterName);
//        Movies movie = findMovieByTitle(MovieTitle);
//
//        if (theater == null) {
//            System.out.println("Theater not found.");
//            return;
//        }
//
//        if (movie == null) {
//            System.out.println("Movie not found.");
//            return;
//        }
//
//        Screen screen = theater.getScreenList().get(screenNumber);
//
//        if (screen == null) {
//            System.out.println("Screen not found.");
//            return;
//        }
//        screen.addShowtime(showtime, MovieTitle);
//        System.out.println("Showtime " + showtime + " for movie " + MovieTitle + " has been set on Screen " + screenNumber + " in Theater " + theaterName);
//    }
//
//    public boolean isValidUser(String uName, String uPassword) {
//        for (User user : this.user.values()) {
//            if (user.getName().equals(uName) && user.getPassword().equals(uPassword)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void displayMovies() {
//
//        for (Movies m : movies){
//            System.out.println(m.getTitle());
//        }
//        System.out.println();
//    }
//
//    public void displayTheatersOnMovie(String movieTitle) {
//        Movies movie = findMovieByTitle(movieTitle);
//        if (movie != null) {
//            List<Theater> theaterList = movie.getTheaterList();
//            if (theaterList != null && !theaterList.isEmpty()) {
//                System.out.println("Theaters showing " + movieTitle + ":");
//                for (Theater theater : theaterList) {
//                    System.out.println(theater.getTheaterName());
//                }
//            } else {
//                System.out.println("No theaters are showing this movie.");
//            }
//        } else {
//            System.out.println("Movie not found.");
//        }
//    }
//
//    public void displayScreensWithShowtimes(String theaterName, String movieTitle) {
//        Theater theater = theaters.get(theaterName);
//        if (theater != null) {
//            System.out.println("Screens in " + theaterName + " showing " + movieTitle + ":");
//            for (Map.Entry<Integer, Screen> entry : theater.getScreenList().entrySet()) {
//                Screen screen = entry.getValue();
//                System.out.println("Screen Number: " + screen.getScreenNumber());
//                System.out.println("Movies and Showtimes:");
//
//                boolean movieFound = false;
//
//                for (Map.Entry<String, String> showtimeEntry : screen.getShowtimes().entrySet()) {
//                    String showtime = showtimeEntry.getKey();
//                    String currentMovieTitle = showtimeEntry.getValue();
//
//                    if (currentMovieTitle.equals(movieTitle)) {
//                        System.out.println("  Showtime: " + showtime + ", Movie: " + movieTitle);
//                        movieFound = true; // Movie was found on this screen
//                    }
//                }
//
//                if (!movieFound) {
//                    System.out.println("  No showtimes for " + movieTitle + " on this screen.");
//                }
//                System.out.println();  // Adding a new line for better readability
//            }
//        } else {
//            System.out.println("Theater not found.");
//        }
//    }
//
//
//    public void displaySeats(String theaterName, int screenNumber, String showtime) {
//        Theater theater = theaters.get(theaterName);
//        if (theater != null) {
//            Screen screen = theater.getScreenList().get(screenNumber);
//            if (screen != null) {
//                String movieTitle = screen.getShowtimes().get(showtime);
//                if (movieTitle != null) {
//                    System.out.println("Movie: " + movieTitle);
//                    System.out.println("Seats for Screen " + screenNumber + " at " + showtime + ":");
//                    displaySeatMap(screen);
//                } else {
//                    System.out.println("Showtime not found.");
//                }
//            } else {
//                System.out.println("Screen not found.");
//            }
//        } else {
//            System.out.println("Theater not found.");
//        }
//    }
//
//    private void displaySeatMap(Screen screen) {
//        int[][] seats = screen.getSeats();
//        for (int i = 0; i < seats.length; i++) {
//            for (int j = 0; j < seats[i].length; j++) {
//                int seatNumber = seats[i][j];
//                if (seatNumber <= 0) {
//                    System.out.print("[X]");
//                } else {
//                    System.out.printf("[%2d]", seatNumber);
//                }
//            }
//            System.out.println();
//        }
//    }
//
//
//    public void bookSeats(String theaterName, int screenNumber, String showtime, List<Integer> seatNumbers) {
//        Theater theater = theaters.get(theaterName);
//        if (theater != null) {
//            Screen screen = theater.getScreenList().get(screenNumber);
//            if (screen != null) {
//                String movieTitle = screen.getShowtimes().get(showtime);
//                if (movieTitle != null) {
//                    int[][] seats = screen.getSeats();
//                    int totalCost = 0;
//                    List<Integer> bookedSeats = new ArrayList<>();
//
//                    for (int seatNumber : seatNumbers) {
//                        int row = (seatNumber - 1) / seats[0].length;
//                        int column = (seatNumber - 1) % seats[0].length;
//
//                        if (seats[row][column] > 0) { // If seat is available
//                            seats[row][column] = 0; // Mark seat as booked
//                            totalCost += 120; // Assuming the cost per seat is 120 INR
//                            bookedSeats.add(seatNumber);
//                            System.out.println("Seat " + seatNumber + " has been booked for " + movieTitle + " at " + showtime);
//                        } else {
//                            System.out.println("Seat " + seatNumber + " is already booked.");
//                        }
//                    }
//
//                    if (!bookedSeats.isEmpty()) {
//                        Booking booking = new Booking(movieTitle, bookedSeats.size(), totalCost, theaterName, screenNumber, bookedSeats);
//                        bookings.add(booking);
//                        System.out.println("Total Bill: " + totalCost + " INR");
//                    }
//                } else {
//                    System.out.println("Showtime not found.");
//                }
//            } else {
//                System.out.println("Screen not found.");
//            }
//        } else {
//            System.out.println("Theater not found.");
//        }
//    }
//
//
//
//    public List<Booking> getBookings() {
//        return bookings;
//    }


}

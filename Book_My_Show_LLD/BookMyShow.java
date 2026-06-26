import Enums.City;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {

        MovieController movieController = new MovieController();
        TheatreController theatreController = new TheatreController();

        public static void main(String[] args) {
            BookMyShow app = new BookMyShow();
            app.initialize();
            app.bookTicket(City.Bangalore, "BAAHUBALI");
            app.bookTicket(City.Bangalore, "BAAHUBALI");
        }

        private void bookTicket(City city, String movieName) {

            Movie movie = movieController.getMovieByName(movieName);

            Show show = theatreController.getAllShow(movie,city).values().iterator().next().get(0);

            int seatNumber=30;
            System.out.println("\nTrying to book seat " + seatNumber +
                    " for " + movieName);
            if(show.getBookedSeatIds().contains(seatNumber)){
                System.out.println("Seat already booked");
                return;
            }
            show.getBookedSeatIds().add(seatNumber);

            System.out.println("BOOKING SUCCESSFUL");

        }

        private void initialize() {

            Movie movie = new Movie();
            movie.setMovieId(1);
            movie.setMovieName("BAAHUBALI");

            movieController.addMovie(movie, City.Bangalore);

            Screen screen = new Screen();
            screen.setScreenId(1);

            Show show = new Show();
            show.setShowId(1);
            show.setMovie(movie);
            show.setScreen(screen);
            show.setShowStartTime(8);

            Theatre theatre = new Theatre();
            theatre.setTheatreId(1);
            theatre.setCity(City.Bangalore);
            theatre.setShows(List.of(show));

            theatreController.addTheatre(theatre, City.Bangalore);
        }

}
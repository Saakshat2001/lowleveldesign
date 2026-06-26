import Enums.City;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

            Map<City, List<Theatre>> cityVsTheatre;
            List<Theatre> allTheatre;
            TheatreController(){
                cityVsTheatre = new HashMap<>();
                allTheatre= new ArrayList<>();
            }

            public void addTheatre(Theatre theatre, City city){
                allTheatre.add(theatre);
                 List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
                 theatres.add(theatre);
                 cityVsTheatre.put(city,theatres);
            }

            // This method exists because after the user selects a movie, the system needs to answer:
    //"Where and when can I watch this movie in my city?"
    //For example:
    //
    //User selects:
    //City  = Bangalore
    //Movie = Bahubali
    //
    //The system should return:
    //
    //INOX
    // ├── 10 AM
    // ├── 2 PM
    // └── 8 PM
            public Map<Theatre, List<Show>> getAllShow(Movie movie, City city){
                Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
                List<Theatre> theatres = cityVsTheatre.get(city);

                for(Theatre theatre : theatres){
                    List<Show> givenMovieShow = new ArrayList<>();
                    List<Show> shows = theatre.getShows();
                    for(Show show : shows){
                            if(show.getMovie().getMovieId() == movie.getMovieId()){
                                givenMovieShow.add(show);
                            }
                    }
                    if(!givenMovieShow.isEmpty()){
                        theatreVsShows.put(theatre, givenMovieShow);
                    }
                }
                return theatreVsShows;
            }
}

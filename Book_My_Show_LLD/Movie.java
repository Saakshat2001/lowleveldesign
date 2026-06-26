public class Movie {


       int movieId;
       String movieName;
       int movieDurationInMinutes;

    public int getMovieId() {
        return movieId;
    }

    public int getMovieDurationInMinutes() {
        return movieDurationInMinutes;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieDurationInMinutes(int movieDurationInMinutes) {
        this.movieDurationInMinutes = movieDurationInMinutes;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

}

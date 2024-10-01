public class RegularMovieFactory extends MovieFactory {
    @Override
    public Movie createMovie(String title) {
        return new RegularMovie(title);
    }
}


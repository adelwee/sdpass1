
public interface MovieSchedule extends Cloneable {
    MovieSchedule clone();
    void setMovie(Movie movie);
    void setTime(String time);
}

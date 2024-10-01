public class IMAXMovie implements Movie {
    private String title;

    public IMAXMovie(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return "IMAX";
    }
}


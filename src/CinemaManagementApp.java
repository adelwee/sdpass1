public class CinemaManagementApp {
    public static void main(String[] args) {
        CinemaConfig config = CinemaConfig.getInstance();
        config.setCinemaName("Starlight Cinemas");
        config.setNumberOfScreens(5);
        System.out.println("Cinema: " + config.getCinemaName() + ", Screens: " + config.getNumberOfScreens());

        MovieFactory regularFactory = new RegularMovieFactory();
        Movie movie = regularFactory.createMovie("Inception");
        System.out.println("Movie: " + movie.getTitle() + ", Type: " + movie.getType());

        UIFactory uiFactory = new DarkThemeFactory();
        Button button = uiFactory.createButton();
        button.render();

        TicketBooking booking = new TicketBookingBuilder()
                .setMovieTitle("Inception")
                .setSeatNumber("A1")
                .setSnackCombo("Popcorn and Soda")
                .build();
        System.out.println(booking);

        StandardSchedule template = new StandardSchedule();
        template.setTime("18:00");
        template.setMovie(movie);

        MovieSchedule eveningSchedule = template.clone();
        eveningSchedule.setTime("21:00");
        System.out.println(eveningSchedule);
    }
}


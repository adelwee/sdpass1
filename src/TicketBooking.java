public class TicketBooking {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;

    public TicketBooking(String movieTitle, String seatNumber, String snackCombo) {
        this.movieTitle = movieTitle;
        this.seatNumber = seatNumber;
        this.snackCombo = snackCombo;
    }

    @Override
    public String toString() {
        return "Movie: " + movieTitle + ", Seat: " + seatNumber + ", Snacks: " + snackCombo;
    }
}

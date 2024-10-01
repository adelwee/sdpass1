public class TicketBookingBuilder {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;

    public TicketBookingBuilder setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
        return this;
    }

    public TicketBookingBuilder setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    public TicketBookingBuilder setSnackCombo(String snackCombo) {
        this.snackCombo = snackCombo;
        return this;
    }

    public TicketBooking build() {
        return new TicketBooking(movieTitle, seatNumber, snackCombo);
    }
}

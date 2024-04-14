

public class Reservation {
    private static int reservationNumber = 0;
    private Flight flight;
    private Passenger passenger;
    private int seatNumber;


    public Reservation(Passenger passenger, Flight flight) {
        this.reservationNumber = reservationNumber + 1;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = flight.getNumberOfPassengers() + 1;

    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public int getSeatNumber() {
        return seatNumber;
    }


}

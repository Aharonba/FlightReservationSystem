import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

/**
 * This class represents a passenger of the airline.
 * It extends the Person class and implements the Observer interface.
 * It has a passport number, a list of reservations and an amount of money (to be sure that when a passenger books a flight he has the financial ability to book it).
 */


public class Passenger extends Person implements Observer {
    private String passportNumber;
    private List<Reservation> reservations;
    private double amountOfMoney;


    public Passenger(String FirstName, String LastName, int Id, String PhoneNumber, String Email, String passportNumber, double amountOfMoney) {
        super(FirstName, LastName, Id, PhoneNumber, Email);
        this.passportNumber = passportNumber;
        this.reservations = new ArrayList<>();
        this.amountOfMoney = amountOfMoney;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    public Reservation createReservation(Flight flight) {
        if (flight.getAvailableSeats() > 0 && this.amountOfMoney >= flight.getPrice()) {
            Reservation reservation = new Reservation(this, flight);
            Payment paymentForFlight = new Payment(reservation, LocalDateTime.now());
            paymentForFlight.makePayment(flight.getPrice());
            this.amountOfMoney = amountOfMoney - flight.getPrice();
            this.addReservation(reservation);
            flight.addReservation(reservation);
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            flight.setNumberOfPassengers(flight.getNumberOfPassengers() + 1);
            System.out.println("Reservation successfully created.\n");
            return reservation;
        } else {
            System.out.println("Reservation not created. Either there are no available seats or you do not have enough money.\n");
            return null;
        }

    }

    public void deleteReservation(Reservation reservation) {
        if (reservations.contains(reservation)) {
            reservations.remove(reservation);
            reservation.getFlight().removeReservation(reservation);
            reservation.getFlight().setAvailableSeats(reservation.getFlight().getAvailableSeats() + 1);
            reservation.getFlight().setNumberOfPassengers(reservation.getFlight().getNumberOfPassengers() - 1);
            this.amountOfMoney = amountOfMoney + reservation.getFlight().getPrice();

            System.out.println("Reservation of: " + getFirstName() + " successfully deleted.");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    @Override
    public void update(String notification) {
        this.addNotification(notification);
    }

}





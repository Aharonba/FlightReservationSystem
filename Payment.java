import java.time.LocalDateTime;

/**
 * This class represents a payment made by a customer for a reservation.
 */

public class Payment {
    private static int paymentID = 0;
    private Reservation reservation;
    private LocalDateTime transactionDateTime;
    private boolean isPaid;
    private double amountPaid;


    public Payment(Reservation reservation, LocalDateTime transactionDateTime) {
        this.reservation = reservation;
        this.transactionDateTime = transactionDateTime;
        this.amountPaid = 0.0;
        this.isPaid = false;
    }


    public int getPaymentID() {
        return paymentID;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void makePayment(double amount) {
        this.amountPaid += amount;
        paymentID++;
        this.isPaid = true;
        System.out.println("Payment of $" + amount + " successfully made.");
    }

}

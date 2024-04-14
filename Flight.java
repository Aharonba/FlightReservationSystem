import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



public class Flight {

    private int flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int capacity;
    private int numberOfPassengers;
    private int availableSeats;
    private int duration;
    private int price;
    private Airport originAirport;
    private Airport destinationAirport;
    private Airline airline;
    private List<Reservation> reservations;
    private static List<Flight> flights = new ArrayList<>();

    private Boolean isValid;


    public Flight(int flightNumber, String origin, String destination, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int capacity, int duration, int price, Airport originAirport, Airport destinationAirport,Airline airline){
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.capacity = capacity;
        this.numberOfPassengers = 0;
        this.availableSeats = capacity;
        this.duration = duration;
        this.price = price;
        this.reservations = new ArrayList<>();
        this.originAirport = originAirport;
        this.destinationAirport = destinationAirport;
        this.airline = airline;
        flights.add(this);
        originAirport.addFlight(this);
        destinationAirport.addFlight(this);
    }

    public static void deleteFlight(Flight flight) {
        flights.remove(flight);
        ;
    }

    public static List<Flight> getFlights() {
        return flights;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getDuration() {
        return duration;
    }

    public int getPrice() {
        return price;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Airport getOriginAirport() {
        return originAirport;
    }

    public Airport getDestinationAirport() {
        return destinationAirport;
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

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //toString
    public String toString() {
        return "\nFlight number: " + flightNumber + "\nOrigin airport: " + originAirport.getAirportName() + " , Destination airport: " + destinationAirport.getAirportName() + "\nDeparture date and time: " + departureDateTime + " , Arrival date and time: " + arrivalDateTime + "\nCapacity: " + capacity + " , number of passengers: " + numberOfPassengers + " , Available seats: " + availableSeats + " , Duration: " + duration + "\nPrice: " + price + "\n";
    }

}
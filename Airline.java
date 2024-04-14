import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * The airline class contains the following fields:
 * 1. Company name.
 * 2. The airline's flight list.
 * 3. List of company employees.
 * 4. The list of people registered to receive updates.
 * 5. List of sub-airlines.
 * <p>
 * Implementation of Composite Pattern:
 * By creating the list of flights and the list of sub-airlines, I build an orderly hierarchical model that allows simple management for the main airline.
 * <p>
 * Implementation of Observer Pattern:
 * The airline class implements the Subject interface, which allows the airline to register, unregister, and notify observers about changes in the airline's status.
 * Creating a new flight, canceling a flight, sales, updating the departure time and changing flight prices are all actions that can be observed by the observers.
 */


public class Airline implements Subject {
    private String name;
    private List<Flight> flights;
    private List<AirlineEmployee> employees;
    private List<Observer> observers;
    private List<Airline> subAirlines;

    public Airline(String name) {
        this.name = name;
        this.flights = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.subAirlines = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addEmployee(AirlineEmployee employee) {
        employees.add(employee);
    }

    public void removeEmployee(AirlineEmployee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            System.out.println(employee.getFirstName() + " left her job at the airline:" + this.name + "\n");
        } else {
            System.out.println("This employee does not work in this company");
        }

    }

    public void addSubAirline(Airline airline) {
        subAirlines.add(airline);
    }

    public void removeSubAirline(Airline airline) {
        subAirlines.remove(airline);
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<AirlineEmployee> getEmployees() {
        return employees;
    }

    public List<Airline> getSubAirlines() {
        return subAirlines;
    }

    /**
     * The following functions are part of the implementation of the observer pattern.
     */

    @Override
    public void register(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregister(Observer observer) {
        if (!observers.contains(observer)) {
            System.out.println("Observer not found.");
            return;
        }
        observers.remove(observer);

    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }

    }

    public Flight createFlight(int flightNumber, String origin, String destination, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int capacity, int duration, int price, Airport originAirport, Airport destinationAirport) {
        Flight flight = new Flight(flightNumber, origin, destination, departureDateTime, arrivalDateTime, capacity, duration, price, originAirport, destinationAirport, this);
        flights.add(flight);
        notifyObservers("There is a new flight from: " + origin + " to: " + destination + " on: " + departureDateTime + " with flight number: " + flightNumber + " and price: " + price + " dollars.");
        return flight;
    }

    public void cancelFlight(Flight flight) {
        if (this.flights.contains(flight)) {
            this.flights.remove(flight);
            flight.getOriginAirport().removeFlight(flight);
            flight.getDestinationAirport().removeFlight(flight);
            Flight.deleteFlight(flight);

            while (!flight.getReservations().isEmpty()) {
                flight.getReservations().getFirst().getPassenger().deleteReservation(flight.getReservations().getFirst());
            }
            notifyObservers("Flight number: " + flight.getFlightNumber() + " from: " + flight.getOrigin() + " to " + flight.getDestination() + " has been canceled.");
            flight = null;
        } else {
            System.out.println("Flight not found.");
        }
    }

    public void sale(String sale) {
        notifyObservers(sale);
        System.out.println(sale + "\n");
    }

    public void updateDepartureTime(Flight flight, LocalDateTime newDepartureTime) {
        //check if the flight is in the airline
        if (!this.flights.contains(flight)) {
            System.out.println("Flight not found.");
            return;
        }
        flight.setDepartureDateTime(newDepartureTime);
        notifyObservers("Flight number: " + flight.getFlightNumber() + " from: " + flight.getOrigin() + " to " + flight.getDestination() + " has a new departure time: " + newDepartureTime);
        System.out.println("Flight number: " + flight.getFlightNumber() + " from: " + flight.getOrigin() + " to " + flight.getDestination() + " has a new departure time: " + newDepartureTime);
    }

    public void updatePrice(Flight flight, int newPrice) {

        if (!this.flights.contains(flight)) {
            System.out.println("Flight not found.");
            return;
        }
        flight.setPrice(newPrice);
        notifyObservers("Flight number: " + flight.getFlightNumber() + " from: " + flight.getOrigin() + " to " + flight.getDestination() + " has a new price: " + newPrice);
        System.out.println("Flight number: " + flight.getFlightNumber() + " from: " + flight.getOrigin() + " to " + flight.getDestination() + " has a new price: " + newPrice+" dollars."+ "\n");
    }


    //to string method

    public String toString() {
        String flightList = "";
        if (this.flights.isEmpty()) {
            flightList = name + " " + "has no flights." + "\n";
        } else {
            for (Flight flight : flights) {
                flightList += flight + " ";
            }
        }


        String employeeList = "";
        if (employees.isEmpty()) {
            employeeList = "There are no employees." + "\n";
        } else {
            for (AirlineEmployee employee : employees) {
                employeeList += employee;
            }
        }

        String subAirlineList = "";
        if (subAirlines.isEmpty()) {
            return name + "\n" + "Flights: " + " " + flightList + "\n" + "Employees:" + "\n" + employeeList + "sub airline: " + "There are no sub airlines." + "\n";
        } else {
            for (Airline airline : subAirlines) {
                subAirlineList += airline + " ";
            }
        }

        return name + "\n" + "Flights: " + " " + flightList + "\n" + "Employees:" + "\n" + employeeList + "\n" + "Sub airlines of " + name + ": " + "\n" + subAirlineList;
    }


}

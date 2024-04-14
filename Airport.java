import java.util.ArrayList;
import java.util.List;


public class Airport {
    private String airportName;
    private Location location;
    private List<Flight> flights;

    public Airport(String airportName, Location location) {
        this.airportName = airportName;
        this.location = location;
        this.flights = new ArrayList<>();
    }

    public String getAirportName() {
        return airportName;
    }

    public Location getLocation() {
        return location;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public void removeFlight(Flight flight) {
        flights.remove(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public String toString() {
        return airportName + " " + flights + location;
    }


}

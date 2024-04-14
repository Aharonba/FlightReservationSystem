import java.util.List;
import java.util.Comparator;

/**
 * This class implements the Strategy interface and sorts the list of flights by their duration.
 */

public class ByFlightDurationSearchStrategy implements Strategy {

    @Override
    public List<Flight> search(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getDuration));
        return flights;
    }


}

import java.util.List;
import java.util.Comparator;

/**
 * This class implements the Strategy interface and sorts the list of flights by their departure time.
 */

public class ByDepartureTimeSearchStrategy implements Strategy {

    @Override
    public List<Flight> search(List<Flight> flights) {
        flights.sort(Comparator.comparing(Flight::getDepartureDateTime));
        return flights;
    }


}

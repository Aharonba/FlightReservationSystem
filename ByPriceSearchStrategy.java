import java.util.Comparator;
import java.util.List;


/**
 * This class implements the Strategy interface and sorts the list of flights by their number of passengers.
 */

public class ByPriceSearchStrategy implements Strategy {
    @Override
    public List<Flight> search(List<Flight> flights) {
        flights.sort(Comparator.comparingInt(Flight::getPrice));
        return flights;
    }

}

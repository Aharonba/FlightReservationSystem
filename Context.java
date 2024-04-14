import java.util.List;


/**
 * This class is the Context class for the Strategy pattern.
 */

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Flight> executeStrategy(List<Flight> flights) {
        return strategy.search(flights);
    }
}

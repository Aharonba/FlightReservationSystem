/**
 * Subject interface for the Observer pattern
 */

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    void notifyObservers(String message);
}

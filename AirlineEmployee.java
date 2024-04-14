/**
 * AirlineEmployee class:
 * This class is a subclass of Person and implements Observer by update method.
 */


public class AirlineEmployee extends Person implements Observer {
    private int employeeNumber;
    private Airline airline;

    public AirlineEmployee(String FirstName, String LastName, int Id, String PhoneNumber, String Email, int EmployeeNumber, Airline airline) {
        super(FirstName, LastName, Id, PhoneNumber, Email);
        this.employeeNumber = EmployeeNumber;
        this.airline = airline;
        airline.addEmployee(this);
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public Airline getAirline() {
        return airline;
    }

    @Override
    public void update(String notification) {
        this.addNotification(notification);
    }

}


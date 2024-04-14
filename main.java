import java.time.LocalDateTime;
import java.util.List;

public class main {
    public static void main(String[] args) {

        // Create airports

        Airport newYorkAirport = new Airport("New york airport", new Location("US", "New york"));
        Airport telAvivAirport = new Airport("Tel aviv airport", new Location("Israel", "Tel Aviv"));
        Airport romeAirport = new Airport("Rome Airport", new Location("Italy", "Rome"));
        Airport londonAirport = new Airport("London Airport", new Location("UK", "London"));


        // Create airlines and create hierarchy of airlines using composite pattern

        Airline el_al = new Airline("EL AL");
        Airline arkia = new Airline("Arkia");
        el_al.addSubAirline(arkia);


        Airline delta = new Airline("Delta");
        Airline openSky = new Airline("openSky");
        delta.addSubAirline(openSky);


        // Creating employees and hiring them for the various airlines

        AirlineEmployee dana = new AirlineEmployee("Dana", "Hen", 206751944, "0545526595", "dana@gmail.com", 10101, el_al);
        AirlineEmployee yael = new AirlineEmployee("Yael", "Cohen", 206751945, "0545526596", "yael@gmail.com", 10102, el_al);
        AirlineEmployee rachel = new AirlineEmployee("Rachel", "Levi", 206751946, "0545526597", "rachel@gmail.com", 10103, delta);
        AirlineEmployee noa = new AirlineEmployee("Noa", "Gotliv", 206751947, "0545526598", "noa@gmail.com,", 10104, delta);
        AirlineEmployee alma = new AirlineEmployee("Alma", "Israeli", 206751948, "0545526599", "alma@gmail.com", 10105, arkia);
        AirlineEmployee omer = new AirlineEmployee("Omer", "Cohen", 206751949, "0545526590", "omer@gmail.com", 10106, openSky);


        // Register employees to receive notifications from the airlines they work for

        el_al.register(dana);
        delta.register(rachel);
        arkia.register(alma);
        openSky.register(omer);

        // Create flights for El Al from Tel Aviv to New York, Delta from New York to Rome, Arkia from Tel Aviv to Rome.

        Flight flight1 = el_al.createFlight(50100, "Tel aviv", "New york", LocalDateTime.of(2024, 4, 10, 8, 0),
                LocalDateTime.of(2024, 4, 10, 10, 0), 100, 120, 1000, telAvivAirport, newYorkAirport);

        Flight flight2 = delta.createFlight(20313, "New york", "Rome", LocalDateTime.of(2024, 4, 11, 8, 0),
                LocalDateTime.of(2024, 4, 11, 11, 0), 150, 180, 1500, newYorkAirport, romeAirport);

        Flight flight3 = arkia.createFlight(50101, "Tel aviv", "Rome", LocalDateTime.of(2024, 5, 1, 20, 0),
                LocalDateTime.of(2024, 5, 2, 8, 0), 200, 600, 2000, telAvivAirport, romeAirport);


        // Print El Al details to show the hierarchy of airlines using composite pattern.
        System.out.println(el_al);



        // Create passengers

        Passenger ben = new Passenger("Ben", "Cohen", 206751932, "0545527345", "ben@gmail.com", "ben123", 3000);
        Passenger shira = new Passenger("Shira", "Levi", 203421221, "0542239012", "shira@gmail.com", "shira123", 2500);
        Passenger ron = new Passenger("Ron", "Israeli", 329114528, "0542197664", "ron@gmail.com", "ron123", 5000);

        //register passengers to receive notifications from the airlines

        el_al.register(ben);
        arkia.register(shira);

        // Shira doesn't want to receive notifications anymore from arkia

        arkia.unregister(shira);

        // yael and rachel stop working for their airlines

        el_al.removeEmployee(yael);
        delta.removeEmployee(rachel);


        // Update flights prices and send notifications to the observers

        el_al.updatePrice(flight1, 750);
        delta.updatePrice(flight2, 1300);


        // Send sale notifications to the observers

        arkia.sale("Special holiday sale all duty free products up to 70 percent off!");

        // Create a new flight for El Al from Tel Aviv to Rome.

        Flight flight4 = el_al.createFlight(50102, "London", "Rome", LocalDateTime.of(2025, 1, 2, 20, 0),
                LocalDateTime.of(2025, 12, 30, 8, 0), 100, 600, 3500, londonAirport, romeAirport);

        // Sort flights by duration and price using strategy pattern

        Context sortingContext = new Context(new ByFlightDurationSearchStrategy());
        List<Flight> sortedFlights = sortingContext.executeStrategy(Flight.getFlights());
        System.out.println("Flights sorted by duration:");
        for (Flight flight : sortedFlights) {
            System.out.println(flight);
        }

        el_al.cancelFlight(flight1);

        //print the notifications of dan and alma to show the notifications they received during the program

        dana.printNotifications();

        alma.printNotifications();


        // Create reservations for passengers

        Reservation reservation2 = shira.createReservation(flight2);
        Reservation reservation3 = ron.createReservation(flight4);

        // Delete a reservation for a passenger and return the money to the passenger

        shira.deleteReservation(reservation2);

        //update the departure time of flight4 and the price of flight4

        flight4.setDepartureDateTime(LocalDateTime.of(2025, 1, 2, 21, 0));
        flight4.setPrice(1750);

        // Sort flights by departure time and number of passengers using strategy pattern

        sortingContext.setStrategy(new ByDepartureTimeSearchStrategy());
        sortedFlights = sortingContext.executeStrategy(Flight.getFlights());
        System.out.println("Flights sorted by departure time:");
        for (Flight flight : sortedFlights) {
            System.out.println(flight);
        }


        Reservation reservation4 = ben.createReservation(flight4);


    }
}



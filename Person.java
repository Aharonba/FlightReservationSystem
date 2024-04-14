import java.util.ArrayList;
import java.util.List;


public abstract class Person {
    private String firstName;
    private String lastName;
    private int id;
    private String phoneNumber;
    private String email;

    private List<String> notifications;


    public Person(String firstName, String lastName, int id, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.notifications = new ArrayList<>();
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void addNotification(String notification) {
        notifications.add(notification);
    }

    public void removeNotification(String notification) {
        notifications.remove(notification);
    }

    //print notifications for a person
    public void printNotifications() {
        System.out.println("Notifications for: " + firstName + " " + lastName + "\n");
        for (String notification : notifications) {
            System.out.println(notification+ "\n");
        }
    }


    @Override
    public String toString() {
        return "Name : " + firstName + " " + lastName + "\n";

    }


}

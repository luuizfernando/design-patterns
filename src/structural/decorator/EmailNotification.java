package structural.decorator;

public class EmailNotification implements Notification {

    @Override
    public void notifyUser(String message) {
        System.out.println("Sending email: " + message);
    }

}
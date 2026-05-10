package creational.factorymethod;

public class EmailNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("Email sent.");
    }

}
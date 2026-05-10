package creational.abstractfactory;

public class MainApp {
    public static void main(String[] args) {

        NotificationFactory factory;
        EmailNotification emailNotification;
        SmsNotification smsNotification;

        // user implementation
        factory = new UserNotificationFactory();
        emailNotification = factory.createEmailNotification();
        smsNotification = factory.createSmsNotification();
        emailNotification.notifyUser();
        smsNotification.notifyUser();

        System.out.println();

        // admin implementation
        factory = new AdminNotificationFactory();
        emailNotification = factory.createEmailNotification();
        smsNotification = factory.createSmsNotification();
        emailNotification.notifyUser();
        smsNotification.notifyUser();

    }
}
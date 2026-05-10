package creational.factorymethod;

public class MainApp {
    public static void main(String[] args) {

        Notification smsNotification = NotificationFactory.createNotification("sms");
        smsNotification.notifyUser();

        Notification emailNotification = NotificationFactory.createNotification("email");
        emailNotification.notifyUser();

        Notification whatsAppNotification = NotificationFactory.createNotification("wpp");
        whatsAppNotification.notifyUser();

        Notification anyNotification = NotificationFactory.createNotification("any");
        anyNotification.notifyUser();

    }
}
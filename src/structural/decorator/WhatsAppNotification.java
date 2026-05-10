package structural.decorator;

public class WhatsAppNotification implements Notification {

    @Override
    public void notifyUser(String message) {
        System.out.println("Sending WhatsApp: " + message);
    }

}
package creational.factorymethod;

public class WhatsAppNotification implements Notification {

    @Override
    public void notifyUser() {
        System.out.println("WhatsApp sent.");
    }

}
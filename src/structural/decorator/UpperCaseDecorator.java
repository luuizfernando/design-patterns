package structural.decorator;

public class UpperCaseDecorator extends  NotificationDecorator {

    public UpperCaseDecorator(Notification notification) {
        super(notification);
    }

    @Override
    public void notifyUser(String message) {
        String upperCaseMessage = message.toUpperCase();
        super.notifyUser(upperCaseMessage);
    }

}
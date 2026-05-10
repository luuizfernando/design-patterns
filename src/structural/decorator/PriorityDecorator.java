package structural.decorator;

/**
 * Decorator that marks a notification as high priority
 * by adding a priority tag to the message.
 */
public class PriorityDecorator extends NotificationDecorator {

    public PriorityDecorator(Notification wrapped) {
        super(wrapped);
    }

    @Override
    public void notifyUser(String message) {
        String priorityMessage = "[PRIORITY] " + message;
        super.notifyUser(priorityMessage);
    }

}
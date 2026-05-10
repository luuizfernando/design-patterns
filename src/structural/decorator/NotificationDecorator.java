package structural.decorator;

/**
 * Abstract decorator that wraps a Notification
 * and forward calls to it.
 */
public abstract class NotificationDecorator implements Notification {

    private Notification wrapped;

    public NotificationDecorator(Notification wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void notifyUser(String message) {
        wrapped.notifyUser(message);
    }

}
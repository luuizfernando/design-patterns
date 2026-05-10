package structural.decorator;

/**
 * Decorator that adds a signature or footer
 * to the end of the message.
 */
public class SignatureDecorator extends NotificationDecorator {

    private final String signature;

    public SignatureDecorator(Notification wrapped, String signature) {
        super(wrapped);
        this.signature = signature;
    }

    @Override
    public void notifyUser(String message) {
        String signatureMessage = message + "\n--- " + signature + " ---";
        super.notifyUser(signatureMessage);
    }

}
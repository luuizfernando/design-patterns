package structural.decorator;

public class MainApp {
    public static void main(String[] args) {

        // Email with priority
        Notification emailNotification = NotificationFactory.createNotification("email");
        Notification priorityEmail = new PriorityDecorator(emailNotification);
        priorityEmail.notifyUser("Course update available.");

        System.out.println();

        // SMS with upper case
        Notification smsNotification = NotificationFactory.createNotification("sms");
        Notification upperCaseSMS = new UpperCaseDecorator(smsNotification);
        upperCaseSMS.notifyUser("Assignment due tomorrow!");

        System.out.println();

        // WhatsApp with signature
        Notification whatsAppNotification = NotificationFactory.createNotification("wpp");
        Notification signatureWhatsApp = new SignatureDecorator(whatsAppNotification, "Luiz");
        signatureWhatsApp.notifyUser("The servers will be down soon");

        System.out.println();

        // WhatsApp with Chained Decorators (Priority => Uppercase => Signature)
        Notification chainedMessage = NotificationFactory.createNotification("wpp");

        Notification chainedWhatsApp =
                new PriorityDecorator(
                        new UpperCaseDecorator(
                                new SignatureDecorator(chainedMessage, "Luiz")
                        )
                );
        chainedWhatsApp.notifyUser("Love your mom");

    }

}
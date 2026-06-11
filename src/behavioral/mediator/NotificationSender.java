package behavioral.mediator;

/**
 * Role: Helper class
 *
 * Sends a notification message after a ticket is processed.
 */
public class NotificationSender {
    public void sendConfirmation(Ticket ticket) {
        System.out.println(
                "[Notification] Sent to " + ticket.getCustomerName()
                + ": Your " + ticket.getIssueType() + " ticket was received."
        );
    }
}

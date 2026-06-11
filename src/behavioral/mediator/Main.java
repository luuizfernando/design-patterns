package behavioral.mediator;

/**
 * Role: Demonstrate the Mediator pattern
 *
 * The SupportCenter (Mediator) coordinates communication between components.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Demo: Support ticket routing ---");

        NotificationSender notificationSender = new NotificationSender();
        SupportCenter supportCenter = new SupportCenter(notificationSender);

        supportCenter.registerService(IssueType.BILLING, new BillingService());
        supportCenter.registerService(IssueType.TECHNICAL, new TechnicalService());

        Ticket billingTicket = new Ticket(
                IssueType.BILLING,
                "Refund not processed",
                "Alice"
        );

        Ticket technicalTicket = new Ticket(
                IssueType.TECHNICAL,
                "App crashing",
                "Bob"
        );

        supportCenter.submitTicket(billingTicket);

        System.out.println();

        supportCenter.submitTicket(technicalTicket);
    }
}

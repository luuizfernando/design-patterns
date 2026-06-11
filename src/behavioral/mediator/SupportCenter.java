package behavioral.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * Role: Concrete Mediator
 *
 * Coordinates ticket routing and customer notification.
 */
public class SupportCenter implements TicketMediator {
    private Map<IssueType, SupportService> supportServices;
    private NotificationSender notificationSender;

    public SupportCenter(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
        supportServices = new HashMap<>();
    }

    public void registerService(IssueType issueType, SupportService supportService) {
        supportServices.put(issueType, supportService);
    }

    @Override
    public void submitTicket(Ticket ticket) {
        System.out.println("[Mediator] Routing " + ticket.getIssueType() + " ticket...");
        SupportService supportService = supportServices.get(ticket.getIssueType());

        if (supportService == null) {
            throw new IllegalStateException("No such support service: " + ticket.getIssueType());
        }

        supportService.handleTicket(ticket);
        notificationSender.sendConfirmation(ticket);
    }
}

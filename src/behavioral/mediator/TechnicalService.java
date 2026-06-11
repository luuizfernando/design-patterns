package behavioral.mediator;

/**
 * Role: Concrete Colleague
 *
 * Handles technical support tickets.
 */
public class TechnicalService implements SupportService {
    @Override
    public void handleTicket(Ticket ticket) {
        System.out.println(
                "[TechnicalService] Escalating to engineering for "
                        + ticket.getCustomerName() + ": " + ticket.getMessage()
        );
    }
}

package behavioral.mediator;

/**
 * Domain object
 *
 * Represents a customer support ticket
 */
public class Ticket {
    private IssueType issueType;
    private String message;
    private String customerName;

    public Ticket(IssueType issueType, String message, String customerName) {
        this.issueType = issueType;
        this.message = message;
        this.customerName = customerName;
    }

    public IssueType getIssueType() {
        return issueType;
    }

    public String getMessage() {
        return message;
    }

    public String getCustomerName() {
        return customerName;
    }
}

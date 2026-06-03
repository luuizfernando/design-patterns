package behavioral.state;

/**
 * Role: Client
 *
 * Demonstrates the State pattern through happy path,
 * backward transition and invalid transition scenarios.
 */
public class Main {
    public static void main(String[] args) {
        // Demo 1: The Happy Path
        System.out.println("\n--- Demo 1: Happy Path ---");
        demonstrateHappyPath();

        // Demo 2: Reopening a closed ticket (backward transition)
        System.out.println("\n--- Demo 2: Backward Transition (REOPEN) ---");
        demonstrateReopenWorkflow();

        // Demo 3: Invalid state transitions
        System.out.println("\n--- Demo 3: INVALID Transitions ---");
        demonstrateInvalidTransitions();
    }

    private static void demonstrateInvalidTransitions() {
        BugTicket ticket = new BugTicket("BUG-103", "Memory leak in background service", "Services consumes excessive memory");

        ticket.printStatus();
        System.out.println("Attempt: Close ticket without starting work ... ");
        try {
            ticket.close();
        } catch (IllegalStateException e) {
            System.out.println("[FAIL] Invalid transition (expected): " + e.getMessage());
        }

        ticket.printStatus();
        System.out.println("Attempt: Reopen a ticket that's not closed ... ");
        try {
            ticket.reopen();
        } catch (IllegalStateException e) {
            System.out.println("[FAIL] Invalid transition (expected): " + e.getMessage());
        }

        ticket.startWork();

        ticket.printStatus();
        System.out.println("Attempt: Start a ticket that's already in progress ... ");
        try {
            ticket.startWork();
        } catch (IllegalStateException e) {
            System.out.println("[FAIL] Invalid transition (expected): " + e.getMessage());
        }

        // Close it properly
        ticket.close();

        ticket.printStatus();
        System.out.println("Attempt: Try to close an already closed ticket ... ");
        try {
            ticket.close();
        } catch (IllegalStateException e) {
            System.out.println("[FAIL] Invalid transition (expected): " + e.getMessage());
        }

        System.out.println("\n[PASS] State transition guards are working correctly!");
    }

    private static void demonstrateReopenWorkflow() {
        BugTicket ticket = new BugTicket("BUG-102", "Dashboard loading slowly", "Takes 10 seconds to load");

        // Complete the workflow
        ticket.startWork();
        ticket.close();
        ticket.printStatus();

        // Bug resurfaces - reopen the ticket
        System.out.println("Bug has resurfaced! Reopening ticket");
        ticket.reopen();
        ticket.printStatus();
        ticket.addComment("Bug reappeared after last system update");

        // Fix it again
        ticket.startWork();
        ticket.close();
        ticket.printStatus();
        System.out.println("Reopen workflow completed successfully");
    }

    private static void demonstrateHappyPath() {
        BugTicket ticket = new BugTicket("BUG-101", "Login button", "Users cannot click the button");
        ticket.printStatus();
        ticket.addComment("Reproduced on mobile browsers");

        // Move from OPEN to IN_PROGRESS
        ticket.startWork();
        ticket.printStatus();
        ticket.addComment("Missing tag");

        // Move from IN_PROGRESS to CLOSED
        ticket.close();
        ticket.printStatus();
        System.out.println("Happy Path completed");
    }
}

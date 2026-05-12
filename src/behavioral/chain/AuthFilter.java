package behavioral.chain;

/**
 * Concrete filter that handles authentication logic.
 *
 * If authentication fails, the chain is terminated.
 * Else, control is passed to the next filter in the chain.
 */
public class AuthFilter implements Filter {

    // Reference to the next filter
    private Filter nextFilter;

    @Override
    public void setNext(Filter filter) {
        this.nextFilter = filter;
    }

    @Override
    public void apply(Request request) {
        System.out.println("[Auth Filter] - Checking authentication for " + request.getPayload());

        if (isAuthenticated(request)) {
            request.setAttribute("authenticated", true);
            System.out.println("[Auth Filter] - Authentication successful");
        } else {
            request.setAttribute("authenticated", false);
            System.out.println("[Auth Filter] - Authentication failed");
            return;
        }

        // Continue to next filter if available
        if (nextFilter != null) {
            nextFilter.apply(request);
        }
    }

    private boolean isAuthenticated(Request request) {
        String payload = request.getPayload();
        return payload.contains("auth");
    }

}
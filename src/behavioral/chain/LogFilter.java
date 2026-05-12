package behavioral.chain;

/**
 * Concrete filter that logs the request
 * Delegates to the next filter
 */
public class LogFilter implements Filter {

    // Reference to the next filter
    private Filter nextFilter;

    @Override
    public void setNext(Filter next) {
        this.nextFilter = next;
    }

    @Override
    public void apply(Request request) {
        System.out.println("[Log Filter] - Logging request: " + request.getPayload());
        request.setAttribute("logged", true);

        if (nextFilter != null) {
            nextFilter.apply(request);
        }

    }

}
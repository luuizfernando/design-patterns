package behavioral.chain;

/**
 * Concrete filter that logs the request
 * Delegates to the next filter
 */
public class CompressionFilter implements Filter {

    // Reference to the next filter
    private Filter nextFilter;

    @Override
    public void setNext(Filter next) {
        this.nextFilter = next;
    }

    @Override
    public void apply(Request request) {
        System.out.println("[Compression Filter] - Compressing payload " + request.getPayload());

        request.setAttribute("compressed", true);

        if (nextFilter != null) {
            nextFilter.apply(request);
        }

    }

}
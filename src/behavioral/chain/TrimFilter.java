package behavioral.chain;

public class TrimFilter implements Filter {

    private Filter nextFilter;

    @Override
    public void setNext(Filter next) {
        this.nextFilter = next;
    }

    @Override
    public void apply(Request request) {
        System.out.println("[Trim Filter] - Trimming payload " + request.getPayload());

        String payload = request.getPayload();
        String trimmedPayload = payload.trim();
        request.setPayload(trimmedPayload);

        request.setAttribute("trimmed", true);

        if (nextFilter != null) {
            nextFilter.apply(request);
        }

    }

}
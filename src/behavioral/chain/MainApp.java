package behavioral.chain;

public class MainApp {
    public static void main(String[] args) {

        // Create the filters
        Filter authFilter = new AuthFilter();
        Filter trimFilter = new TrimFilter();
        Filter logFilter = new LogFilter();
        Filter compressionFilter = new CompressionFilter();

        // Build the filter chain: Auth => Log => Compression
        authFilter.setNext(trimFilter);
        trimFilter.setNext(logFilter);
        logFilter.setNext(compressionFilter);

        // Request #1 => Passes authentication
        Request request1 = new Request("                         auth-payload                          ");
        // Start processing the request
        System.out.println("=== Starting processing request 01 ===");
        authFilter.apply(request1);
        System.out.println("Final request 01 state: " + request1);

        System.out.println();

        // Request #2 => Fails authentication
        Request request2 = new Request("             payload   ");
        // Start processing the request
        System.out.println("=== Starting processing request 02 ===");
        authFilter.apply(request2);
        System.out.println("Final request 02 state: " + request2);
        System.out.println("Notice how request 02 stops early!");

    }
}
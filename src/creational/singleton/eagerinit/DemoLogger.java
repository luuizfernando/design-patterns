package creational.singleton.eagerinit;

public class DemoLogger {

    private static final DemoLogger instance =  new DemoLogger();

    private DemoLogger() {
        System.out.println("Creating a new instance of DemoLogger");
    }

    public static DemoLogger getInstance() {
        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

}
package creational.singleton.threadsafe;

public class DemoLogger {

    private static DemoLogger instance;

    private DemoLogger() {
        System.out.println("Creating a new instance of DemoLogger");
    }

    // Adição da keyword synchronized (uma thread por vez)
    public synchronized static DemoLogger getInstance() {
        if (instance == null) {
            instance = new DemoLogger();
        }

        return instance;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

}
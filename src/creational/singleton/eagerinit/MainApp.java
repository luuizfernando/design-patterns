package creational.singleton.eagerinit;

public class MainApp {
    public static void main(String[] args) {
        DemoLogger instance1 = DemoLogger.getInstance();
        instance1.log("Instance 01");
        DemoLogger instance2 = DemoLogger.getInstance();
        instance2.log("Instance 02");
    }
}
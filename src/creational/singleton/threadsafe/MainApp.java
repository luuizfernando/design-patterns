package creational.singleton.threadsafe;

public class MainApp {
    public static void main(String[] args) {
        DemoLogger instance1 = DemoLogger.getInstance();
        instance1.log("Instance 01");
        DemoLogger instance2 = DemoLogger.getInstance();
        instance2.log("Instance 02");

        System.out.println();

        boolean flag = (instance1 == instance2);
        System.out.println("Are instance1 and instance2 the same? " + flag);
    }
}
package creational.singleton.billpugh;

public class DemoLogger {

    private DemoLogger() {
        System.out.println("Creating a new instance of DemoLogger");
    }

    public static DemoLogger getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    // Classe estática interna tem a instância
    // Ela não é carregada até que metodo getInstance() seja chamado
    // Garante lazy initialization e thread safety
    private static class SingletonHelper {
        private static final DemoLogger INSTANCE = new DemoLogger();
    }

}
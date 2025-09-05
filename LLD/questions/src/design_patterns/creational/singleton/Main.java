package design_patterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println(logger1 == logger2);

        logger1.log("Hi! I am Sandipan Mahata");

        logger1.setLogLevel(LogLevel.ERROR);
        logger2.log("Hello! I am logger 2");
    }
}

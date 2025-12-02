package logger;

public class Main {
    static void main() {
        Logger logger = Logger.getInstance();

        logger.info("Hi! How are you");
        logger.debug("Debug! What are you doing");

        logger.error("ERROR! great");
    }
}

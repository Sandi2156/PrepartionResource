package logging;

public class Main {
    public static void main(String[] args) {
        Formatter formatter = new TextFormatter();
        Logger logger = Logger.getLoggerInstance(formatter);
        logger.addDestination(new ConsoleLogDestination());

        logger.log(LogLevel.DEBUG, "Hi How are you?");
    }
}

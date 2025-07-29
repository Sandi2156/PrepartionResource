package logging;

public class TextFormatter implements Formatter{
    public String format(LogLevel level, String message) {
        return "Loglevel: " + level.name() + " | Message: " + message;
    }
}

package logging;

public class JsonFormatter implements Formatter{
    public String format(LogLevel level, String message) {
        return "{ \"level\": \"" + level + "\", \"message\": \"" + message + "\" }";
    }
}

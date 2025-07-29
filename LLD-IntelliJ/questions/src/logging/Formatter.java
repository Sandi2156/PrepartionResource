package logging;

public interface Formatter {
    public String format(LogLevel level, String message);
}

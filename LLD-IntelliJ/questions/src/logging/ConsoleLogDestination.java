package logging;

public class ConsoleLogDestination implements LogDestination {
    public void log(String text) {
        System.out.println("Logged in Console: " + text);
    }
}

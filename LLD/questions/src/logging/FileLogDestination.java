package logging;

public class FileLogDestination implements LogDestination{
    private String location;

    public FileLogDestination(String location) {
        this.location = location;
    }

    public void log(String text) {
        System.out.println("Logged in location : " + this.location + ", text: " + text);
    }
}

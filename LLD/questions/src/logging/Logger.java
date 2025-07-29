package logging;

import java.util.*;

public class Logger {
    private static Logger logger;
    private final Formatter formatter;
    private final List<LogDestination> logDestinationList = new ArrayList<>();
    private Logger(Formatter formatter) {
        this.formatter = formatter;
    }

    public static synchronized Logger getLoggerInstance(Formatter formatter) {
        if(logger == null) {
            logger = new Logger(formatter);
        }
        return logger;
    }

    public void addDestination(LogDestination logDestination) {
        this.logDestinationList.add(logDestination);
    }

    public void log(LogLevel logLevel, String text) {
        String formattedText = formatter.format(logLevel, text);
        for(LogDestination logDestination: logDestinationList) {
            logDestination.log(formattedText);
        }
    }
}

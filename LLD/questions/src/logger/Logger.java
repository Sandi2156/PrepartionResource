package logger;

import logger.appender.ConsoleAppender;
import logger.appender.FileAppender;
import logger.enums.LogLevel;
import logger.formatter.StringFormatter;
import logger.handler.DebugHandler;
import logger.handler.ErrorHandler;
import logger.handler.IHandler;
import logger.handler.InfoHandler;
import logger.models.LogMessage;

import java.util.Date;

public class Logger {
    private final IHandler handler;
    private static Logger logger;

    private Logger() {
        IHandler errorHandler = new ErrorHandler(null);
        errorHandler.subscribe(new ConsoleAppender(new StringFormatter()));
        errorHandler.subscribe(new FileAppender(new StringFormatter(), "output.txt"));

        IHandler debugHandler = new DebugHandler(errorHandler);
        debugHandler.subscribe(new ConsoleAppender(new StringFormatter()));

        IHandler infoHandler = new InfoHandler(debugHandler);
        infoHandler.subscribe(new ConsoleAppender(new StringFormatter()));

        this.handler = infoHandler;
    }

    public static Logger getInstance() {
        if(logger == null) {
            synchronized (Logger.class) {
                if(logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    private void log(LogMessage message) {
        handler.handle(message);
    }

    public void info(String message) {
        this.log(new LogMessage(LogLevel.INFO, message, 900));
    }

    public void debug(String message) {
        this.log(new LogMessage(LogLevel.DEBUG, message, 900));
    }

    public void error(String message) {
        this.log(new LogMessage(LogLevel.ERROR, message, 900));
    }
}

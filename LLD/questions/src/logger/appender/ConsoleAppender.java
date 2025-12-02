package logger.appender;

import logger.formatter.IFormatter;
import logger.models.LogMessage;

public class ConsoleAppender extends IAppender{

    public ConsoleAppender(IFormatter formatter) {
        super(formatter);
    }

    @Override
    public void append(LogMessage message) {
        System.out.println(this.formatter.format(message));
    }
}

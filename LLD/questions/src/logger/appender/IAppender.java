package logger.appender;

import logger.formatter.IFormatter;
import logger.models.LogMessage;

public abstract class IAppender {
    protected final IFormatter formatter;

    public IAppender(IFormatter formatter) {
        this.formatter = formatter;
    }

    public abstract void append(LogMessage message);
}

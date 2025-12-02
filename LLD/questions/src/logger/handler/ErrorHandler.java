package logger.handler;

import logger.enums.LogLevel;
import logger.models.LogMessage;

public class ErrorHandler extends IHandler{
    public ErrorHandler(IHandler next) {
        super(next);
    }

    @Override
    public boolean canHandle(LogMessage message) {
        return LogLevel.ERROR == message.getLogLevel();
    }
}

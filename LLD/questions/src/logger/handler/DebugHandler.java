package logger.handler;

import logger.enums.LogLevel;
import logger.models.LogMessage;

public class DebugHandler extends IHandler{
    public DebugHandler(IHandler next) {
        super(next);
    }

    @Override
    public boolean canHandle(LogMessage message) {
        return LogLevel.DEBUG == message.getLogLevel();
    }
}

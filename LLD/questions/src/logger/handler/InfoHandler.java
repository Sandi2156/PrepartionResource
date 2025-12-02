package logger.handler;

import logger.enums.LogLevel;
import logger.models.LogMessage;

public class InfoHandler extends IHandler{
    public InfoHandler(IHandler next) {
        super(next);
    }

    @Override
    public boolean canHandle(LogMessage message) {
        return LogLevel.INFO == message.getLogLevel();
    }
}

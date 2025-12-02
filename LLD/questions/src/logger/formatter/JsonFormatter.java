package logger.formatter;

import logger.models.LogMessage;

public class JsonFormatter implements IFormatter{

    public String format(LogMessage message) {
        return "{\"message\": " + message.getMessage() + "}";
    }
}

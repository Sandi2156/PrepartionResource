package logger.formatter;

import logger.models.LogMessage;

public class StringFormatter implements IFormatter {

    public String format(LogMessage message) {
        return "Date: Time: " + message.getMessage();
    }
}

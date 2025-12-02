package logger.formatter;

import logger.models.LogMessage;

public interface IFormatter {
    public String format(LogMessage message);
}

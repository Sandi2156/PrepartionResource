package logger.models;

import logger.enums.LogLevel;

public class LogMessage {
    private LogLevel logLevel;
    private String message;
    private long timestamp;

    public LogMessage(LogLevel logLevel, String message, long timestamp) {
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = timestamp;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

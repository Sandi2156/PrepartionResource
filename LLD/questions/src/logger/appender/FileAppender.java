package logger.appender;

import logger.formatter.IFormatter;
import logger.models.LogMessage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppender extends IAppender{
    private final BufferedWriter writer;

    public FileAppender(IFormatter formatter, String fileName) {
        super(formatter);

        try {
            this.writer = new BufferedWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            throw new RuntimeException("Failed to open log file. ", e);
        }
    }

    private void close() {
        try {
            this.writer.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public synchronized void append(LogMessage message) {
        try {
            this.writer.write(formatter.format(message));
            this.writer.newLine();
            this.writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.close();
        }
    }
}

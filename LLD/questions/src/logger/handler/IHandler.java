package logger.handler;

import logger.appender.IAppender;
import logger.models.LogMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class IHandler {
    protected IHandler next;
    protected List<IAppender> observers;

    public IHandler(IHandler next) {
        this.next = next;
        this.observers = new CopyOnWriteArrayList<>();
    }

    public void subscribe(IAppender observer) {
        this.observers.add(observer);
    }

    public void notifyObservers(LogMessage message) {
        for(IAppender appender: this.observers) {
            appender.append(message);
        }
    }

    public void handle(LogMessage message) {
        if(this.canHandle(message)) notifyObservers(message);
        else if(next != null) next.handle(message);
    }

    public abstract boolean canHandle(LogMessage message);
}

package amazon_locker.notification;

import java.util.List;

public interface NotificationStrategy {
    public void send(List<String> recipients, String message);
}

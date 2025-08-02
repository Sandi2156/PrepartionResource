package amazon_locker.notification;

public class NotificationFactory {
    public static NotificationStrategy getNotificationObject(NotificationEnum notificationEnum) {
        switch(notificationEnum) {
            case SMS:
                return new SMSNotification();
            case EMAIL:
                return new EmailNotification();
            default:
                return new SMSNotification();
        }
    }
}

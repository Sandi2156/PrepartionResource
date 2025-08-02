package amazon_locker.locker;

import amazon_locker.Repository;
import amazon_locker.Size;
import amazon_locker.notification.NotificationEnum;
import amazon_locker.notification.NotificationFactory;
import amazon_locker.notification.NotificationStrategy;
import amazon_locker.user.User;

import java.util.ArrayList;
import java.util.List;

public class LockerManager {
    private Locker locker = new Locker();
    private NotificationStrategy notificationStrategy;
    private Repository repository = new Repository();

    public LockerManager(NotificationEnum notificationEnum) {
        notificationStrategy = NotificationFactory.getNotificationObject(notificationEnum);
    }

    public void putItem(Size size, User user) {
        LockerItem lockerItem = locker.getLockerWithSize(size);

        if(lockerItem == null) {
            System.out.println("There is no locker available with this size");
            return;
        }

        locker.putItem(lockerItem.getLockerId());

        List<String> users = new ArrayList<>();
        users.add(user.getUserId());
        notificationStrategy.send(users, "Your parcel is placed in locker id " + lockerItem.getLockerId());
    }

    public void getItem(String code, String lockerId) {
        LockerItem lockerItem = locker.getLockerWithID(lockerId);

        if(lockerItem == null) {
            System.out.println("This locker does not exist");
            return;
        }

        if(!repository.verifyOTP(code,lockerId)) {
            System.out.println("It is not a valid code, please type again");
            return;
        }

        locker.removeItem(lockerItem.getLockerId());
    }

    public void addLocker(String lockerId, Size size) {
        locker.addLockerItem(size, lockerId);
    }
}

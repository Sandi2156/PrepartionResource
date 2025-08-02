package amazon_locker.locker;

import amazon_locker.Size;

import java.util.ArrayList;
import java.util.List;

public class Locker {
    private List<LockerItem> lockerItems = new ArrayList<>();

    public LockerItem getLockerWithSize(Size size) {
        for(LockerItem lockerItem: lockerItems) {
            if(lockerItem.getLockerSize() == size && !lockerItem.isOccupied())
                return lockerItem;
        }

        return null;
    }

    public LockerItem getLockerWithID(String lockerId) {
        for(LockerItem lockerItem: lockerItems) {
            if(lockerItem.getLockerId() == lockerId)
                return lockerItem;
        }

        return null;
    }

    public void putItem(String lockerId) {
        LockerItem lockerItem = null;
        for(LockerItem item: lockerItems) {
            if(lockerId == item.getLockerId()) {
                lockerItem = item;
                break;
            }
        }

        if(lockerItem == null) {
            System.out.println("This locker does not exist!");
            return;
        }

        lockerItem.setOccupied(true);
    }

    public LockerItem removeItem(String lockerId) {
        LockerItem lockerItem = getLockerWithID(lockerId);

        if(lockerItem == null) {
            System.out.println("There is no locker with this ID!");
            return null;
        }

        lockerItems.remove(lockerItem);
        return lockerItem;
    }

    public void addLockerItem(Size size, String lockerId) {
        LockerItem lockerItem = getLockerWithID(lockerId);

        if(lockerItem != null) {
            System.out.println("There is already a locker with this id!");
            return;
        }

        lockerItem = new LockerItem(lockerId, size);
        lockerItems.add(lockerItem);
    }
}

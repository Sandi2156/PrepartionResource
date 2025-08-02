package amazon_locker.locker;

import amazon_locker.Size;

public class LockerItem {
    private String lockerId;
    private boolean isOccupied;
    private Size lockerSize;

    public LockerItem(String lockerId, Size lockerSize) {
        this.lockerId = lockerId;
        this.lockerSize = lockerSize;
        this.isOccupied = false;
    }

    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Size getLockerSize() {
        return lockerSize;
    }

    public void setLockerSize(Size lockerSize) {
        this.lockerSize = lockerSize;
    }
}

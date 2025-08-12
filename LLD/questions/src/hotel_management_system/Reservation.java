package hotel_management_system;

import java.util.Date;

public class Reservation {
    private User user;
    private int floorNo;
    private int roomNo;
    private ReservationStatus reservationStatus;
    private CheckInStatus checkInStatus;
    private Date checkedInDate;
    private Date checkedOutDate;

    public Reservation(User user, int floorNo, int roomNo, Date checkedInDate, Date checkedOutDate) {
        this.user = user;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.checkedInDate = checkedInDate;
        this.checkedOutDate = checkedOutDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public CheckInStatus getCheckInStatus() {
        return checkInStatus;
    }

    public void setCheckInStatus(CheckInStatus checkInStatus) {
        this.checkInStatus = checkInStatus;
    }

    public Date getCheckedInDate() {
        return checkedInDate;
    }

    public void setCheckedInDate(Date checkedInDate) {
        this.checkedInDate = checkedInDate;
    }

    public Date getCheckedOutDate() {
        return checkedOutDate;
    }

    public void setCheckedOutDate(Date checkedOutDate) {
        this.checkedOutDate = checkedOutDate;
    }
}

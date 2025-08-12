package hotel_management_system;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelManagementSystem {
    private final Hotel hotel;
    private Map<String, User> userMap;
    private Map<String, List<Reservation>> reservationMap;



    public HotelManagementSystem() {
        this.hotel = new Hotel(new Location("Hadapsar", "Pune", 411028));
        this.userMap = new HashMap<>();
        this.reservationMap = new HashMap<>();
    }


    public Reservation bookRoom(String userName, String id, RoomType roomType, Date checkedInDate, Date checkedOutDate) {
        User user;
        if(userMap.containsKey(userName)) {
            user = userMap.get(userName);
        } else {
            user = new User(userName, id);
            userMap.put(userName, user);
        }

        List<Integer> room = this.hotel.getRoomDetails(roomType);

        Reservation reservation = new Reservation(user, room.get(0), room.get(1), checkedInDate, checkedOutDate);

        List<Reservation> userReservation = reservationMap.get(userName);
        userReservation.add(reservation);
        reservationMap.put(userName, userReservation);

        return reservation;
    }

    public void checkIn(String userName) {

    }

    public Receipt checkOut(String userName) {
        // create receipt
        return null;
    }

    public void makePayment(Receipt receipt, PaymentType paymentType) {
        // make payment
    }


}

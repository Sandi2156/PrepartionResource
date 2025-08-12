package hotel_management_system;

import java.util.Map;

public class Floor {
    private int floorNo;
    Map<Integer, Room> roomMap;

    public Floor(int floorNo) {
        this.floorNo = floorNo;

        roomMap.put(1, new Room(1, RoomType.SINGLE, 3000));
        roomMap.put(2, new Room(2, RoomType.DOUBLE, 8000));
        roomMap.put(3, new Room(3, RoomType.KING, 13000));
        roomMap.put(4, new Room(4, RoomType.SUITE, 33000));
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public Map<Integer, Room> getRoomMap() {
        return roomMap;
    }

    public void setRoomMap(Map<Integer, Room> roomMap) {
        this.roomMap = roomMap;
    }
}

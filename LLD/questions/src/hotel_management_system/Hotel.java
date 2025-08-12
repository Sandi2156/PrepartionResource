package hotel_management_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Hotel {
    private Location location;
    private Map<Integer, Floor> floorMap;

    public Hotel(Location location) {
        this.location = location;
        floorMap.put(1, new Floor(1));
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<Integer, Floor> getFloorMap() {
        return floorMap;
    }

    public void setFloorMap(Map<Integer, Floor> floorMap) {
        this.floorMap = floorMap;
    }

    public List<Integer> getRoomDetails(RoomType roomType) {
        return new ArrayList<>();
    }
}

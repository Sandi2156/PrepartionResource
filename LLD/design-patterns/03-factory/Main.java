interface Ride {
    public void book();
}

class CarRide implements Ride {

    @Override
    public void book() {
        System.out.println("I have booked a car!");
    }
}

class AutoRide implements Ride {

    @Override
    public void book() {
        System.out.println("I have booked a auto!");
    }
}

class BikeRide implements Ride {
    @Override
    public void book() {
        System.out.println("I have booked a bike!");
    }
}

class RideFactory {
    public Ride getRide(String type) {
        switch(type.toLowerCase()) {
            case "car":
                return new CarRide();
            case "auto":
                return new AutoRide();
            case "bike":
                return new BikeRide();
            default:
                return null;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        RideFactory rideFactory = new RideFactory();

        Ride ride1 = rideFactory.getRide("car");
        ride1.book();

        Ride ride2 = rideFactory.getRide("auto");
        ride2.book();

        Ride ride3 = rideFactory.getRide("bike");
        ride3.book();
    }
}

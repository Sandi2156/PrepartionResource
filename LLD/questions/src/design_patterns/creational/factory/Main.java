package design_patterns.creational.factory;

interface Ride {
    public void bookRide();
}

class Regular implements Ride {
    public void bookRide() {
        System.out.println("Regular Ride is booked");
    }
}

class XL implements Ride {
    public void bookRide() {
        System.out.println("XL is booked");
    }
}

class Van implements Ride {
    public void bookRide() {
        System.out.println("Van is booked");
    }
}

class RideFactory {
    public static Ride getRide(String rideType) {
        switch (rideType.toLowerCase()) {
            case "regular":
                return new Regular();
            case "xl":
                return new XL();
            case "van":
                return new Van();
            default:
                return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Ride ride1 = RideFactory.getRide("XL");
        Ride ride2 = RideFactory.getRide("van");

        ride1.bookRide();
        ride2.bookRide();
    }
}

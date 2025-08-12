interface Ride {
    public double getFare();
    public String getDescription();
}

class CarRide implements Ride {
    public double getFare() {
        return 100;
    }

    public String getDescription() {
        return "Car Ride";
    }
}

class BikeRide implements Ride {
    public double getFare() {
        return 100;
    }

    public String getDescription() {
        return "Bike Ride";
    }
}

// decorator
abstract class RideDecorator implements Ride {
    private Ride ride;

    public RideDecorator(Ride ride) {
        this.ride = ride;
    } 

    public double getFare() {
        return this.ride.getFare();
    }

    public String getDescription() {
        return this.ride.getDescription();
    }
}

class PremiumRide extends RideDecorator {
    public PremiumRide(Ride ride) {
        super(ride);
    }

    public double getFare() {
        return super.getFare() * 3;
    }

    public String getDescription() {
        return super.getDescription() + " , Premimum Ride";
    }
}

class SurchargeRide extends RideDecorator {
    public SurchargeRide(Ride ride) {
        super(ride);
    }

    public double getFare() {
        return super.getFare() * 2;
    }

    public String getDescription() {
        return super.getDescription() + " , Surcharge Ride";
    }
}

public class Main {
    public static void main(String[] args) {
        Ride carRide = new CarRide();
        carRide = new PremiumRide(carRide);
        System.out.println(carRide.getDescription());
        System.out.println(carRide.getFare());
        

        Ride bikRide = new BikeRide();
        bikRide = new SurchargeRide(bikRide);
        System.out.println(bikRide.getDescription());
        System.out.println(bikRide.getFare());
    }
}

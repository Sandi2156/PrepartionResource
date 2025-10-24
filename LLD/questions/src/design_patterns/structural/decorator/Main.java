package design_patterns.structural.decorator;

// Base Interface
interface IRide {
    public double getCost();
    public String getDescription();
}

class BasicRide implements IRide {
    public double getCost() {
        return 90;
    }

    public String getDescription() {
        return "Base Ride";
    }
}

// Decorator Class
abstract class RideDecorator implements IRide {
    private IRide ride;

    public RideDecorator(IRide ride) {
        this.ride = ride;
    }

    @Override
    public double getCost() {
        return ride.getCost();
    }

    @Override
    public String getDescription() {
        return ride.getDescription();
    }
}

// Concrete Decorators
class UberXL extends RideDecorator {
    public UberXL(IRide ride) {
        super(ride);
    }

    @Override
    public double getCost() {
        return super.getCost() * 1.2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", UberXL";
    }
}

class ChildSeat extends RideDecorator {
    public ChildSeat(IRide ride) {
        super(ride);
    }

    @Override
    public double getCost() {
        return super.getCost() * 1.2;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", ChildSeat";
    }
}

public class Main {
    public static void main(String[] args) {
        IRide ride = new BasicRide();

        ride = new UberXL(ride);
        ride = new ChildSeat(ride);

        System.out.println(ride.getDescription());
        System.out.println(ride.getCost());
    }
}

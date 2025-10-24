package design_patterns.creational.builder;

class RideBooking {
    private String pickUpLocation;
    private String dropOffLocation;

    // optional parameters
    private String carType;
    private double expectedFare;
    private boolean isACAvailable;

    private RideBooking(Builder builder) {
        pickUpLocation = builder.pickUpLocation;
        dropOffLocation = builder.dropOffLocation;
        carType = builder.carType;
        expectedFare = builder.expectedFare;
        isACAvailable = builder.isACAvailable;
    }

    public static class Builder {
        private String pickUpLocation;
        private String dropOffLocation;

        // optional parameters
        private String carType = "Regular";
        private double expectedFare = 100;
        private boolean isACAvailable = false;

        public Builder(String pickUpLocation, String dropOffLocation) {
            this.pickUpLocation = pickUpLocation;
            this.dropOffLocation = dropOffLocation;
        }

        public Builder withCarType(String carType) {
            this.carType = carType;
            return this;
        }

        public Builder withExpectedFare(double fare) {
            this.expectedFare = fare;
            return this;
        }

        public Builder withAC(boolean ac) {
            this.isACAvailable = ac;
            return this;
        }

        public RideBooking build() {
            return new RideBooking(this);
        }
    }

    @Override
    public String toString() {
        return "Ride Details: " + "pickup: " + this.pickUpLocation + ", drop: " + this.dropOffLocation + ", carType: " + this.carType + ", fare: " + this.expectedFare + ", AC: " + this.isACAvailable;
    }
}

public class Main {
    public static void main(String[] args) {
        RideBooking rideBooking1 = new RideBooking.Builder("Hadapsar", "Lonavla").build();
        RideBooking rideBooking2 = new RideBooking.Builder("Mumbai", "Pune").withCarType("XL").withExpectedFare(12).withAC(true).build();

        System.out.println(rideBooking1);
        System.out.println(rideBooking2);

    }
}

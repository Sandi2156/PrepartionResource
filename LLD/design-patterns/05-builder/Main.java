class RideRequest {

    // required parameters
    private final String riderName;
    private final String pickupLocation;
    private final String dropLocation;

    // optional parameters
    private final String paymentMethod;
    private final String promoCode;
    private final String preferredDriver;

    // private constructor
    private RideRequest(Builder builder) {
        this.riderName = builder.riderName;
        this.pickupLocation = builder.pickupLocation;
        this.dropLocation = builder.dropLocation;
        this.paymentMethod = builder.paymentMethod;
        this.promoCode = builder.promoCode;
        this.preferredDriver = builder.preferredDriver;
    }

    // static Builder inner class
    public static class Builder {
        private final String riderName;
        private final String pickupLocation;
        private final String dropLocation;

        private String paymentMethod;
        private String promoCode;
        private String preferredDriver;

        public Builder(String riderName, String pickup, String drop) {
            this.riderName = riderName;
            this.pickupLocation = pickup;
            this.dropLocation = drop;
        }

        public Builder paymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder promoCode(String promoCode) {
            this.promoCode = promoCode;
            return this;
        }

        public Builder preferredDriver(String preferredDriver) {
            this.preferredDriver = preferredDriver;
            return this;
        }

        public RideRequest build() {
            return new RideRequest(this);
        }
    }

    // for displaying the request
    public void showRequest() {
        System.out.println("Ride for: " + riderName);
        System.out.println("From: " + pickupLocation + " To: " + dropLocation);
        System.out.println("Payment: " + paymentMethod);
        System.out.println("Promo: " + promoCode);
        System.out.println("Preferred Driver: " + preferredDriver);
    }
}

public class Main {
    public static void main(String[] args) {
        RideRequest request = new RideRequest.Builder("Alice", "Home", "Airport")
                .paymentMethod("UPI")
                .promoCode("SAVE20")
                .preferredDriver("John")
                .build();

        request.showRequest();
    }
}

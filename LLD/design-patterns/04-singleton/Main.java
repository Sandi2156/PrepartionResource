class RidePricingEngine {

    // Step 1: private static instance
    private static RidePricingEngine instance;

    // Step 2: private constructor to prevent instantiation
    private RidePricingEngine() {
        System.out.println("Pricing engine initialized...");
    }

    // Step 3: public method to get the instance
    public static synchronized RidePricingEngine getInstance() {
        if (instance == null) {
            instance = new RidePricingEngine();
        }
        return instance;
    }

    public double calculateFare(String rideType, int distanceKm) {
        double baseFare = switch (rideType.toLowerCase()) {
            case "bike" -> 5.0;
            case "auto" -> 7.0;
            case "car" -> 10.0;
            default -> 8.0;
        };
        return baseFare * distanceKm;
    }
}

public class Main {
    public static void main(String[] args) {
        // You always get the same instance
        RidePricingEngine engine1 = RidePricingEngine.getInstance();
        RidePricingEngine engine2 = RidePricingEngine.getInstance();

        // Same object? true
        System.out.println("Same instance? " + (engine1 == engine2));

        double fare = engine1.calculateFare("car", 12);
        System.out.println("Estimated fare: $" + fare);
    }
}

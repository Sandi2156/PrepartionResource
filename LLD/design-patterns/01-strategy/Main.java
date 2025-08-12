interface FareStrategy {
    public double calculateFare(int distanceKm);
}

class RegularFare implements FareStrategy {
    @Override
    public double calculateFare(int distanceKm) {
        return 5 * distanceKm;
    }
}

class SurgeFare implements FareStrategy {
    @Override
    public double calculateFare(int distanceKm) {
        return 90 * distanceKm;
    }
}

class NightFare implements FareStrategy {
    @Override
    public double calculateFare(int distanceKm) {
        return 9 * distanceKm;
    }
}

class FareCalculator {
    private FareStrategy fareStrategy;

    public FareCalculator(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public void setFareStrategy(FareStrategy fareStrategy) {
        this.fareStrategy = fareStrategy;
    }

    public double calculateFare(int distanceKm) {
        return fareStrategy.calculateFare(distanceKm);
    }
}

public class Main {
    public static void main(String[] args) {
        FareStrategy fareStrategy = new RegularFare();
        FareCalculator fCalculator = new FareCalculator(fareStrategy);

        System.out.println(fCalculator.calculateFare(190));

        fCalculator.setFareStrategy(new SurgeFare());
        System.out.println(fCalculator.calculateFare(190));

        fCalculator.setFareStrategy(new NightFare());
        System.out.println(fCalculator.calculateFare(190));
    }
}

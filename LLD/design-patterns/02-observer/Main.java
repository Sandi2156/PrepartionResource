/*
 * Subject
 * Concrete Subject
 * 
 * Observer
 * Concrete Observer
 * 
 */

import java.util.ArrayList;
import java.util.List;

interface Observer {
    public void update(String location);
}

interface Subject {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObserver();
}

class RideTracker implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String currentLocation;
    
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer o: observers) {
            o.update(currentLocation);
        }
    }

    public void updateLocation(String location) {
        this.currentLocation = location;
        notifyObserver();
    }
}

class RiderApp implements Observer {
    public void update(String location) {
        System.out.println("Locaiton of the ride is updated in Rider App : " + location);
    }
}

class DriverApp implements Observer {
    public void update(String location) {
        System.out.println("Locaiton of the ride is updated in Driver App : " + location);
    }
}

public class Main {
    public static void main(String[] args) {
        Observer riderApp = new RiderApp();
        Observer driverApp = new DriverApp();

        RideTracker rideTracker = new RideTracker();
        rideTracker.addObserver(driverApp);
        rideTracker.addObserver(riderApp);

        rideTracker.updateLocation("Point A");
        rideTracker.updateLocation("Point B");

        rideTracker.removeObserver(driverApp);
        rideTracker.updateLocation("Point C");
    }
}

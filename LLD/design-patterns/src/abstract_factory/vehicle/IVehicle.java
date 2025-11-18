package abstract_factory.vehicle;

public abstract class IVehicle {
    public void start() {
        System.out.println("Started the vehicle");
    }

    public void stop() {
        System.out.println("Stopped the vehicle");
    }
}

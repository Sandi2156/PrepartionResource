package abstract_factory;

import abstract_factory.abstract_factory.IVehicleAbstractFactory;
import abstract_factory.vehicle.IVehicle;

public class Main {
    public static void main(String[] args) {
        FactoryProducer factoryProducer = new FactoryProducer();

        IVehicleAbstractFactory vehicleAbstractFactory = factoryProducer.getVehicleFactory("premium");
        IVehicle vehicle = vehicleAbstractFactory.getInstance(90000000);

        vehicle.start();
        vehicle.stop();
    }
}

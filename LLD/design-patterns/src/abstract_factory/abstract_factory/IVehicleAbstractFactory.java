package abstract_factory.abstract_factory;

import abstract_factory.vehicle.IVehicle;

public interface IVehicleAbstractFactory {
    public IVehicle getInstance(int price);
}

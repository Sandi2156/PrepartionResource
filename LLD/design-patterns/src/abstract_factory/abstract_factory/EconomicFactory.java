package abstract_factory.abstract_factory;

import abstract_factory.vehicle.Economic1;
import abstract_factory.vehicle.Economic2;
import abstract_factory.vehicle.IVehicle;

public class EconomicFactory implements IVehicleAbstractFactory{
    public IVehicle getInstance(int price) {
        if(price < 500000) return new Economic1();
        return new Economic2();
    }
}

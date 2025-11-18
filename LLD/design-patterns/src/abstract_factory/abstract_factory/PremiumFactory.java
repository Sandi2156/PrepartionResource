package abstract_factory.abstract_factory;

import abstract_factory.vehicle.IVehicle;
import abstract_factory.vehicle.Premium1;
import abstract_factory.vehicle.Premium2;

public class PremiumFactory implements IVehicleAbstractFactory{
    public IVehicle getInstance(int amount) {
        if(amount < 3000000) return new Premium1();
        return new Premium2();
    }
}

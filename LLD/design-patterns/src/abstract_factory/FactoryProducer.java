package abstract_factory;

import abstract_factory.abstract_factory.EconomicFactory;
import abstract_factory.abstract_factory.IVehicleAbstractFactory;
import abstract_factory.abstract_factory.PremiumFactory;

public class FactoryProducer {
    public IVehicleAbstractFactory getVehicleFactory(String type) {
        if(type.equalsIgnoreCase("economic"))
            return new EconomicFactory();
        else if(type.equalsIgnoreCase("premium"))
            return new PremiumFactory();
        return null;
    }
}

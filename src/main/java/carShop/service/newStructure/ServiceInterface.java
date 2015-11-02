package carShop.service.newStructure;

import carShop.core.entity.Car;
import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by employee on 10/30/15.
 */
public interface ServiceInterface extends CarsServiceInterface, ManagersServiceInterface, DealsServiceInterface{
    void buyingCar();
    Manager getBestManager();
}

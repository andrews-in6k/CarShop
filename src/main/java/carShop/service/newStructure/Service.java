package carShop.service.newStructure;

import carShop.core.entity.Car;
import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by employee on 10/30/15.
 */
public interface Service {
    void addCar(Car car);
    void addManager(Manager manager);
    void addDeal(Deal deal);

    void removeCar(Car car);
    void removeManager(Manager manager);
    void removeDeal(Deal deal);

    List<Car> getCars();
    List<Manager> getManagers();
    List<Deal> getDeals();

    Car getCarById();
    Manager getManagerById();
    Deal getDealById();
}

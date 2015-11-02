package carShop.service.trash;

import carShop.core.entity.Car;
import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public interface CarShopServiceInterface {
    boolean hasCars();

    boolean isAvailableCar(Car car);

    void buyingCar(LocalDate buyingDate, int inputIntegerManager, int inputIntegerCar);

    void addDeal(Deal deal);

    Manager getBestManager(LocalDate startDate, LocalDate endDate);

    void addCar(Car car);

    void addManager(Manager salesManager);

    void removeCar(Car car);

    void removeManager(Manager salesManager);

    void removeDeal(Deal deal);

    void removeCarByIndex(int number);

    void removeManagerByIndex(int number);

    List<Car> getCars();

    List<Manager> getManagers();

    List<Deal> getDeals();

}

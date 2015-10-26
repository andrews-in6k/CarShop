package carShop.service;

import carShop.entity.Car;
import carShop.entity.Deal;
import carShop.entity.Manager;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public interface CarShopServiceInterface {
    boolean hasCars();

    boolean hasSold(Car car);

    void buyingCar(LocalDate buyingDate, int inputIntegerManager, int inputIntegerCar);

    void addDeal(Deal deal);

    Manager getBestManager(LocalDate startDate, LocalDate endDate);

    void addCar(Car car);

    void addManager(Manager salesManager);

    void removeCar(Car car);

    void removeManager(Manager salesManager);

    List<Car> getCars();

    List<Manager> getManagers();

    List<Deal> getDeals();

}

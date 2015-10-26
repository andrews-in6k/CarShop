package carShop.service;

import carShop.Car;
import carShop.Deal;
import carShop.SalesManager;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public interface CarShopServiceInterface {
    boolean hasCars();

    void buyingCar(LocalDate buyingDate, int inputIntegerManager, int inputIntegerCar);

    void addDeal(Deal deal);

    SalesManager getBestSalesManager(LocalDate startDate, LocalDate endDate);

    void addCar(Car car);

    void addSalesManager(SalesManager salesManager);

    void removeCar(Car car);

    void removeSalesManager(SalesManager salesManager);

    List<Car> getCars();

    List<SalesManager> getSalesManagers();

    List<Deal> getDeals();

}

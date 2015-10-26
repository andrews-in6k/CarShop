package carShop;

import carShop.entity.Car;
import carShop.entity.Deal;
import carShop.entity.Manager;

import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public interface CarShopPrinter {
    void printAvailableCars(List<Car> cars);
    void printSalesManagers(List<Manager> salesManagers);
    void printDeals(List<Deal> deals);
    void printSalesManagerDeals(Manager manager);

    void printMainMenu();
    void printInputBrand() ;
    void printInputCarName();
    void printInputCost();
    void printInputManagerName();
    void printInputManagerSurname();
    void printChooseCarByNumber();
    void printChooseManagerByNumber();
    void printInputBuyingDate();
    void printInputStartDate();
    void printInputEndDate();
}

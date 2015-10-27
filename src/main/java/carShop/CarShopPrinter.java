package carShop;

import carShop.core.entity.Car;
import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public interface CarShopPrinter {
    void printAvailableCars(List<Car> cars);
    void printSalesManagers(List<Manager> salesManagers);
    void printDeals(List<Deal> deals);
    void printManagerDeals(Manager manager);

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
    void printWrongSymbol();
}

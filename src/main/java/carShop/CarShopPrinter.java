package carShop;

import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public interface CarShopPrinter {
    void printAvailableCars(List<Car> cars);
    void printSalesManagers(List<SalesManager> salesManagers);
    void printDeals(List<Deal> deals);
    void printSalesManagerDeals(SalesManager salesManager);
}

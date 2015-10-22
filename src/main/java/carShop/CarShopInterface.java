package carShop;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by anri on 20.10.15.
 */
public interface CarShopInterface {
    boolean hasCars();

    void addDeal(Deal deal);

    void buyingCar(LocalDate buyingDate, int inputIntegerManager, int inputIntegerCar);

    SalesManager getBestSalesManager(LocalDate startDate, LocalDate endDate);

    void addCar(Car car);

    void addSalesManager(SalesManager salesManager);

    void removeCar(Car car);

    void removeSalesManager(SalesManager salesManager);

    List<Car> getCars();

    List<SalesManager> getSalesManagers();

    List<Deal> getDeals();

}

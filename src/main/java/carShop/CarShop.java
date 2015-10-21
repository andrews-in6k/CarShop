package carShop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by employee on 10/20/15.
 */
public class CarShop implements CarShopInterface{
    private List<Car> cars = new ArrayList<>();
    private List<SalesManager> salesManagers = new ArrayList<>();
    private List<Deal> deals = new ArrayList<>();

    public CarShop() {
        addSalesManager(new SalesManager("Manager", "Default"));
    }

    public void addDeal(Deal deal) {
        deals.add(deal);
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addSalesManager(SalesManager salesManager) {
        salesManagers.add(salesManager);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void removeSalesManager(SalesManager salesManager) {
        salesManagers.remove(salesManager);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<SalesManager> getSalesManagers() {
        return salesManagers;
    }

    public List<Deal> getDeals() {
        return deals;
    }
}

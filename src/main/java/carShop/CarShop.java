package carShop;

import java.time.LocalDate;
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
        salesManagers.add(new SalesManager("Manager", "Default"));
    }

    public boolean hasCars() {
        return !getCars().isEmpty();
    }

    public void buyingCar(LocalDate buyingDate ,int inputIntegerManager, int inputIntegerCar) {
        Deal deal = new Deal(
                buyingDate,
                getSalesManagers().get(inputIntegerManager),
                getCars().get(inputIntegerCar));

        addDeal(deal);
    }

    public void addDeal(Deal deal) {
        deals.add(deal);
        deal.getSalesManager().addDeal(deal);
        removeCar(deal.getSoldCar());
    }

    public SalesManager getBestSalesManager(LocalDate startDate, LocalDate endDate) {
        SalesManager bestSalesManager = getSalesManagers().get(0);
        int maxDealsCount = 0;

        for (SalesManager salesManager : getSalesManagers()) {
            int pretendingMaxDealsCount = 0;

            for (Deal deal : salesManager.getDeals()) {
                if (deal.getDate().isAfter(startDate) && deal.getDate().isBefore(endDate)) {
                    pretendingMaxDealsCount++;
                }
            }

            if (pretendingMaxDealsCount > maxDealsCount) {
                bestSalesManager = salesManager;
                maxDealsCount = pretendingMaxDealsCount;
            }
        }

        return bestSalesManager;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addSalesManager(SalesManager salesManager) {
        removeDefaultManager();

        salesManagers.add(salesManager);
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public void removeSalesManager(SalesManager salesManager) {
        salesManagers.remove(salesManager);
    }

    private void removeDefaultManager() {
        if (hasDefault()) {
            removeSalesManager(getSalesManagers().get(0));
        }
    }

    private boolean hasDefault() {
        return getSalesManagers().get(0).getSurname().equals("Default");
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

package carShop.service;

import carShop.core.dao.CarDAO;
import carShop.core.dao.DealDAO;
import carShop.core.dao.ManagerDAO;
import carShop.core.entity.Car;
import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public class CarShopService implements CarShopServiceInterface{

    private CarDAO carDAO;
    private DealDAO dealDAO;
    private ManagerDAO managerDAO;

    public CarShopService(CarDAO carDAO, DealDAO dealDAO, ManagerDAO managerDAO) {
        this.carDAO = carDAO;
        this.dealDAO = dealDAO;
        this.managerDAO = managerDAO;
    }

    @Override
    public void buyingCar(LocalDate buyingDate, int managerIndex, int carIndex) {
        Deal deal = new Deal();

        //TODO Date -> LocalDate
        deal.setBuyingDate(Date.from(buyingDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        deal.setManager(managerDAO.getTableRows().get(managerIndex));
        deal.setSoldCar(getAvailableCarByIndex(carIndex));

        addDeal(deal);
    }

    private Car getAvailableCarByIndex(int carIndex) {
        Car buyingCar = carDAO.getTableRows().get(0);
        int notSoldCarIndex = 0;

        for (Car car : carDAO.getTableRows()) {
            if (notSoldCarIndex == carIndex) {
                buyingCar = car;
            }

            //TODO method isSold
            if (car.getDeal() == null) {
                notSoldCarIndex++;
            }
        }

        return buyingCar;
    }

    @Override
    public Manager getBestManager(LocalDate startDate, LocalDate endDate) {
        Manager bestSalesManager = managerDAO.getTableRows().get(0);
        int maxDealsCount = 0;

        for (Manager manager : managerDAO.getTableRows()) {
            int pretendingMaxDealsCount = 0;

            for (Deal deal : manager.getDeals()) {
                LocalDate buyingDate;
                buyingDate = deal.getBuyingDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if (buyingDate.isAfter(startDate) && buyingDate.isBefore(endDate)) {
                    pretendingMaxDealsCount++;
                }
            }

            if (pretendingMaxDealsCount > maxDealsCount) {
                bestSalesManager = manager;
                maxDealsCount = pretendingMaxDealsCount;
            }
        }

        return bestSalesManager;
    }

    @Override
    public boolean hasCars() {
        return carDAO.getTableRows().size() != 0;
    }

    @Override
    public void addDeal(Deal deal) {
        dealDAO.save(deal);

        deal.getSoldCar().setDeal(deal);

        carDAO.update(deal.getSoldCar());
    }

    @Override
    public void addCar(Car car) {
        carDAO.save(car);
    }

    @Override
    public void addManager(Manager manager) {
        managerDAO.save(manager);
    }

    @Override
    public void removeCar(Car car) {
        carDAO.delete(car);
    }

    @Override
    public void removeManager(Manager manager) {
        for (Deal deal : manager.getDeals()){
            removeDeal(deal);
        }

        managerDAO.delete(manager);
    }

    @Override
    public void removeDeal(Deal deal) {
        Car car = deal.getSoldCar();

        dealDAO.delete(deal);

        removeCar(car);
    }

    @Override
    public void removeCarByIndex(int number) {
        removeCar(getAvailableCarByIndex(number));
    }

    @Override
    public void removeManagerByIndex(int number) {
        removeManager(managerDAO.getTableRows().get(number));
    }

    @Override
    public List<Car> getCars() {
        return carDAO.getTableRows();
    }

    @Override
    public List<Deal> getDeals() {
        return dealDAO.getTableRows();
    }

    @Override
    public List<Manager> getManagers() {
        return managerDAO.getTableRows();
    }

    //******************************************************************************************************************
    //NEW METHODS
    //******************************************************************************************************************

    public Car getCarById(int id) {
        return carDAO.getCarById(id);
    }

    public Manager getManagerById(int id) {
        return managerDAO.getManagerById(id);
    }

    public void removeCarById(int id) {
        removeCar(getCarById(id));
    }

    public void removeManagerById(int id) {
        removeManager(getManagerById(id));
    }
}

package carShop.service.newStructure;

import carShop.core.dao.CarDAO;
import carShop.core.dao.DealDAO;
import carShop.core.dao.ManagerDAO;
import carShop.core.entity.Car;
import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by employee on 10/30/15.
 */
public abstract class Service implements ServiceInterface{
    private CarDAO carDAO;
    private DealDAO dealDAO;
    private ManagerDAO managerDAO;

    public Service(CarDAO carDAO, DealDAO dealDAO, ManagerDAO managerDAO) {
        this.carDAO = carDAO;
        this.dealDAO = dealDAO;
        this.managerDAO = managerDAO;
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
    public void addDeal(Deal deal) {
        dealDAO.save(deal);

        deal.getSoldCar().setDeal(deal);

        carDAO.update(deal.getSoldCar());
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
    public List<Car> getCars() {
        return carDAO.getTableRows();
    }

    @Override
    public List<Manager> getManagers() {
        return managerDAO.getTableRows();
    }

    @Override
    public List<Deal> getDeals() {
        return dealDAO.getTableRows();
    }

    @Override
    public Car getCarById(int id) {
        return carDAO.getCarById(id);
    }

    @Override
    public Manager getManagerById(int id) {
        return managerDAO.getManagerById(id);
    }
    
    @Override
    public Deal getDealById(int id) {
        return dealDAO.getDealById(id);
    }
}

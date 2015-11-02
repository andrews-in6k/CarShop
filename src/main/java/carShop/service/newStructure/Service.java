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
public class Service implements ServiceInterface{
    private CarsService carsService;
    private ManagersService managersService;
    private DealsService dealsService;

    public Service(CarsService carsService, ManagersService managersService, DealsService dealsService) {
        this.carsService = carsService;
        this.managersService = managersService;
        this.dealsService = dealsService;
    }

    @Override
    public void buyingCar() {

    }

    @Override
    public Manager getBestManager() {
        return null;
    }

    @Override
    public void addCar(Car car) {
        carsService.addCar(car);
    }

    @Override
    public void addManager(Manager manager) {
        managersService.addManager(manager);
    }

    @Override
    public void addDeal(Deal deal) {
        dealsService.addDeal(deal);
    }

    @Override
    public void removeCar(Car car) {
        carsService.removeCar(car);
    }

    @Override
    public void removeManager(Manager manager) {
        managersService.removeManager(manager);
    }

    @Override
    public void removeDeal(Deal deal) {
        dealsService.removeDeal(deal);
    }

    @Override
    public List<Car> getCars() {
        return carsService.getCars();
    }

    @Override
    public List<Manager> getManagers() {
        return managersService.getManagers();
    }

    @Override
    public List<Deal> getDeals() {
        return dealsService.getDeals();
    }

    @Override
    public Car getCarById(int id) {
        return carsService.getCarById(id);
    }

    @Override
    public Manager getManagerById(int id) {
        return managersService.getManagerById(id);
    }

    @Override
    public Deal getDealById(int id) {
        return dealsService.getDealById(id);
    }
}

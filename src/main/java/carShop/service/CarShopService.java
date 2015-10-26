package carShop.service;

import carShop.Car;
import carShop.SalesManager;
import carShop.dao.CarDAO;
import carShop.dao.DealDAO;
import carShop.dao.ManagerDAO;
import carShop.entity.Deal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public class CarShopService implements CarShopServiceInterface{

    CarDAO carDAO;
    DealDAO dealDAO;
    ManagerDAO managerDAO;

    public CarShopService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);
        carDAO = (CarDAO) context.getBean("dataDaoCar");
        dealDAO = (DealDAO) context.getBean("dataDaoDeal");
        managerDAO = (ManagerDAO) context.getBean("dataDaoManager");
    }

    @Override
    public void buyingCar(LocalDate buyingDate, int inputIntegerManager, int inputIntegerCar) {

    }

    @Override
    public boolean hasCars() {
        return false;
    }

    @Override
    public SalesManager getBestSalesManager(LocalDate startDate, LocalDate endDate) {
        return null;
    }

    @Override
    public void addDeal(carShop.Deal deal) {

    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void addSalesManager(SalesManager salesManager) {

    }

    @Override
    public void removeCar(Car car) {

    }

    @Override
    public void removeSalesManager(SalesManager salesManager) {

    }

    @Override
    public List<Car> getCars() {
        return null;
    }

    @Override
    public List<carShop.Deal> getDeals() {
        return null;
    }

    @Override
    public List<SalesManager> getSalesManagers() {
        return null;
    }
}

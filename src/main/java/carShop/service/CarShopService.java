package carShop.service;

import carShop.entity.Car;
import carShop.entity.Manager;
import carShop.dao.CarDAO;
import carShop.dao.DealDAO;
import carShop.dao.ManagerDAO;
import carShop.entity.Deal;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public class CarShopService implements CarShopServiceInterface{
    private Manager defaultManager;

    private CarDAO carDAO;
    private DealDAO dealDAO;
    private ManagerDAO managerDAO;

    public CarShopService() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" }, true);
        carDAO = (CarDAO) context.getBean("dataDaoCar");
        dealDAO = (DealDAO) context.getBean("dataDaoDeal");
        managerDAO = (ManagerDAO) context.getBean("dataDaoManager");

        if (managerDAO.getTableRows().size() == 0) {
            defaultManager = new Manager();

            defaultManager.setFirstName("Default");
            defaultManager.setLastName("Manager");

            managerDAO.save(defaultManager);
        }
    }

    @Override
    public void buyingCar(LocalDate buyingDate, int inputIntegerManager, int inputIntegerCar) {
        Deal deal = new Deal();

        deal.setBuyingDate(Date.from(buyingDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        deal.setManager(managerDAO.getTableRows().get(inputIntegerManager));
        deal.setSoldCar(carDAO.getTableRows().get(inputIntegerCar));

        addDeal(deal);
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
    public boolean hasSold(Car car) {
        return car.getDeal() != null;
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
        if (managerDAO.getTableRows().get(0).equals(defaultManager)) {
            removeManager(defaultManager);
        }

        managerDAO.save(manager);
    }

    @Override
    public void removeCar(Car car) {
        carDAO.delete(car);
    }

    @Override
    public void removeManager(Manager manager) {
        managerDAO.delete(manager);
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
}

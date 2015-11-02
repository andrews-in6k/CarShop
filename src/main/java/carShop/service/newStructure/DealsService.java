package carShop.service.newStructure;

import carShop.core.dao.DealDAO;
import carShop.core.entity.Car;
import carShop.core.entity.Deal;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class DealsService implements DealsServiceInterface{

    private DealDAO dealDAO;
    private CarsService carsService;

    public DealsService(DealDAO dealDAO, CarsService carsService) {
        this.dealDAO = dealDAO;
        this.carsService = carsService;
    }

    @Override
    public void addDeal(Deal deal) {
        dealDAO.save(deal);
    }

    @Override
    public void removeDeal(Deal deal) {
        Car car = deal.getSoldCar();

        dealDAO.delete(deal);

        carsService.removeCar(car);
    }

    @Override
    public List<Deal> getDeals() {
        return dealDAO.getTableRows();
    }

    @Override
    public Deal getDealById(int id) {
        return dealDAO.getDealById(id);
    }
}

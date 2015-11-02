package carShop.service.newStructure;

import carShop.core.dao.DealDAO;
import carShop.core.entity.Deal;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public class DealsService implements DealsServiceInterface{

    private DealDAO dealDAO;

    public DealsService(DealDAO dealDAO) {
        this.dealDAO = dealDAO;
    }

    @Override
    public void addDeal(Deal deal) {
        dealDAO.save(deal);
    }

    @Override
    public void removeDeal(Deal deal) {
        dealDAO.delete(deal);
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

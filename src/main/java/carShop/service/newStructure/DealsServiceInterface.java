package carShop.service.newStructure;

import carShop.core.entity.Deal;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public interface DealsServiceInterface {

    void addDeal(Deal deal);
    void removeDeal(Deal deal);
    List<Deal> getDeals();
    Deal getDealById(int id);

}

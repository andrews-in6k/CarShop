package carShop.core.dao;

import carShop.core.entity.Deal;
import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public class DealDAO extends DAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Deal> getTableRows(){
        return sessionFactory.getCurrentSession()
                .createQuery("from Deal")
                .list();
    }

    public Deal getDealById(int id) {
        return sessionFactory.getCurrentSession().get(Deal.class, id);
    }
}

package carShop.core.dao;

import carShop.core.entity.Deal;

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

}

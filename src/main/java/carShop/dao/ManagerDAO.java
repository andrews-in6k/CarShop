package carShop.dao;

import carShop.entity.Manager;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public class ManagerDAO extends DAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Manager> getTableRows(){
        return sessionFactory.getCurrentSession()
                .createCriteria(Manager.class)
                .list();
    }

}

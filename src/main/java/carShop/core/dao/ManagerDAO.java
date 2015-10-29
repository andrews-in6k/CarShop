package carShop.core.dao;

import carShop.core.entity.Car;
import carShop.core.entity.Manager;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
public class ManagerDAO extends DAO {

    @Override
    @SuppressWarnings("unchecked")
    public List<Manager> getTableRows(){
        return sessionFactory.getCurrentSession()
                .createQuery("from Manager")
                .list();
    }

    public Manager getManagerById(int id) {
        return sessionFactory.getCurrentSession().get(Manager.class, id);
    }
}

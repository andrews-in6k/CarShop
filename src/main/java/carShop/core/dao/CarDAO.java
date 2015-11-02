package carShop.core.dao;

import carShop.core.dao.newStructure.BaseDAO;
import carShop.core.entity.Car;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
public class CarDAO extends BaseDAO<Car> {

//    @Override
//    @SuppressWarnings("unchecked")
//    public List<Car> getTableRows() {
//        return sessionFactory.getCurrentSession()
//                .createQuery("from Car")
//                .list();
//    }
//
//    public Car getCarById(int id) {
//        return sessionFactory.getCurrentSession().get(Car.class, id);
//    }
}

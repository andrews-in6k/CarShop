package carShop.dao;

import carShop.entity.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by employee on 10/23/15.
 */
@Transactional
public class CarDAO implements CarDAOInterface {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> getCars() {
        return sessionFactory.getCurrentSession()
                .createCriteria(Car.class)
                .list();
    }

    @Override
    public void addCar(Object object) {

    }

    @Override
    public void removeCar(Object object) {

    }
}

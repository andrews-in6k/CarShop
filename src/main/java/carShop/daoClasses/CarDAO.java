package carShop.daoClasses;

import carShop.entityClasses.Car;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;
/**
 * Created by employee on 10/23/15.
 */
public class CarDAO extends HibernateDaoSupport implements CarDAOInterface{

    @Autowired
    private SessionFactory sessionFactory;
    private static Session session;



    public CarDAO() {
        session = sessionFactory.openSession();
    }

    @Override
    public List<Car> getCars() {
        return session.createQuery("from Car").list();
    }

    @Override
    public void addCar(Object object) {

    }

    @Override
    public void removeCar(Object object) {

    }
}

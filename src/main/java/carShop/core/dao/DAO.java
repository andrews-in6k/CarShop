package carShop.core.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by employee on 10/26/15.
 */
@Transactional
public abstract class DAO {

    @Autowired
    protected SessionFactory sessionFactory;

    public abstract List getTableRows();

    public void save(Object object){
        sessionFactory.getCurrentSession().save(object);
    }

    public void delete(Object object){
        sessionFactory.getCurrentSession().delete(object);
    }

    public void update(Object object){
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }
}

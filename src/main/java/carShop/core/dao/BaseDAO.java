package carShop.core.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
@Transactional
public abstract class BaseDAO<T> implements BaseDAOInterface<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    private Class<T> type;

    @SuppressWarnings("unchecked")
    public BaseDAO() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<T> getTableRows(){
        return sessionFactory.getCurrentSession()
                .createQuery("from " + type.getSimpleName())
                .list();
    }

    @Override
    public T getById(int id){
        return sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void save(T object){
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void delete(T object){
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public void update(T object){
        sessionFactory.getCurrentSession().saveOrUpdate(object);
    }
}

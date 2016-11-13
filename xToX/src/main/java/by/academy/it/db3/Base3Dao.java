package by.academy.it.db3;


import by.academy.it.util3.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public class Base3Dao<T> implements Dao3<T> {
    public static Session session = HibernateUtil.getHibernateUtil().getSession();
    private static Logger log = Logger.getLogger(Base3Dao.class);
    private Transaction transaction = null;


    public Base3Dao() {
    }

    public void saveOrUpdate(T t) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            transaction.commit();
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao3" + e);
            transaction.rollback();
            throw new DaoException(e);
        }

    }

    public T get(Serializable id) throws DaoException {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            transaction = session.beginTransaction();
            t = (T) session.get(getPersistentClass(), id);
//            session.refresh(t);                     // Petko: my edition
            transaction.commit();
            log.info("get() clazz:" + t);
        } catch (HibernateException e) {
            transaction.rollback();
            log.error("Error get() " + getPersistentClass() + " in Dao3" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public T load(Serializable id) throws DaoException {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            transaction = session.beginTransaction();
            t = (T) session.load(getPersistentClass(), id);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao3" + e);
            transaction.rollback();
            throw new DaoException(e);
        }
        return t;
    }

    public void delete(T t) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
            log.info("Delete:" + t);
        } catch (IllegalArgumentException | HibernateException e) {
            log.error("Error delete " + getPersistentClass() + " in Dao3" + e);
            transaction.rollback();
            throw new DaoException(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}

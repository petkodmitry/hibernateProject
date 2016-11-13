package by.academy.it.db4;


import by.academy.it.util4.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public class Base4Dao<T> implements Dao4<T> {
    public static Session session = HibernateUtil.getHibernateUtil().getSession();
    private static Logger log = Logger.getLogger(Base4Dao.class);
    private Transaction transaction = null;


    public Base4Dao() {
    }

    public void saveOrUpdate(T t) throws DaoException4 {
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            transaction.commit();
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao4" + e);
            transaction.rollback();
            throw new DaoException4(e);
        }

    }

    public T get(Serializable id) throws DaoException4 {
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
            log.error("Error get() " + getPersistentClass() + " in Dao4" + e);
            throw new DaoException4(e);
        }
        return t;
    }

    public T load(Serializable id) throws DaoException4 {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            transaction = session.beginTransaction();
            t = (T) session.load(getPersistentClass(), id);
            transaction.commit();
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao4" + e);
            transaction.rollback();
            throw new DaoException4(e);
        }
        return t;
    }

    public void delete(T t) throws DaoException4 {
        try {
            transaction = session.beginTransaction();
            session.delete(t);
            transaction.commit();
            log.info("Delete:" + t);
        } catch (IllegalArgumentException | HibernateException e) {
            log.error("Error delete " + getPersistentClass() + " in Dao4" + e);
            transaction.rollback();
            throw new DaoException4(e);
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

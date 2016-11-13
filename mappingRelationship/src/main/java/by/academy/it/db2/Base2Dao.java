package by.academy.it.db2;


import by.academy.it.util2.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;


public class Base2Dao<T> implements Dao2<T> {
    public static Session session = HibernateUtil.getHibernateUtil().getSession();
    private static Logger log = Logger.getLogger(Base2Dao.class);
    private Transaction transaction = null;


    public Base2Dao() {
    }

    public void saveOrUpdate(T t) throws DaoException {
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
            transaction.commit();
            log.info("Save or update (commit):" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao2" + e);
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
            transaction.commit();
            log.info("get() clazz:" + t);
        } catch (HibernateException e) {
            transaction.rollback();
            log.error("Error get() " + getPersistentClass() + " in Dao2" + e);
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
            log.error("Error load() " + getPersistentClass() + " in Dao2" + e);
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
        } catch (HibernateException e) {
            log.error("Error delete " + getPersistentClass() + " in Dao2" + e);
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

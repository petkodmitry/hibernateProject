package by.academy.it.db4;

import java.io.Serializable;

public interface Dao4<T> {
    void saveOrUpdate(T t) throws DaoException4;

    T get(Serializable id) throws DaoException4;

    T load(Serializable id) throws DaoException4;

    void delete(T t) throws DaoException4;
}

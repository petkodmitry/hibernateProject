package by.academy.it.db3;

import java.io.Serializable;

public interface Dao3<T> {
    void saveOrUpdate(T t) throws DaoException;

    T get(Serializable id) throws DaoException;

    T load(Serializable id) throws DaoException;

    void delete(T t) throws DaoException;
}

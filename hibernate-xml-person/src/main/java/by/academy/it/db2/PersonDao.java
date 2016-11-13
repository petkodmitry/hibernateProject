/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.academy.it.db2;

import by.academy.it.db2.exceptions.DaoException;
import by.academy.it.pojos2.Person;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import static by.academy.it.loader2.PersonLoader.util;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 13:05
 */
public class PersonDao extends BaseDao<Person> {

    private static Logger log = Logger.getLogger(PersonDao.class);

    public void flush(Integer id, String newName) throws DaoException {
        try {
            Session session = util.getSession();
            Person p = (Person)session.get(Person.class, id);
//            setTransaction(session.beginTransaction());     // mine
            System.out.println(p);
            p.setName(newName);
            System.out.println(p);
            session.flush();
//            getTransaction().commit();                      // mine
            System.out.println(p);
        } catch (HibernateException e) {
            log.error("Error Flush person" + e);
            throw new DaoException(e);
        }

    }

    public void refresh(Integer id, String newName) throws DaoException {
        try {
            Session session = util.getSession();
            Person p = (Person)session.get(Person.class, id);
//            setTransaction(session.beginTransaction());     // mine
            System.out.println(p);
            p.setName(newName);
            System.out.println(p);
            session.refresh(p);
//            getTransaction().commit();                      // mine
            System.out.println(p);
        } catch (HibernateException e) {
            log.error("Error Refresh person" + e);
            throw new DaoException(e);
        }

    }
}

package by.academy.it.db2;

import by.academy.it.pojos2.PersonComponent;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

public class PersonComponentDao extends Base2Dao<PersonComponent> {
    private static PersonComponentDao instance;

    private PersonComponentDao() {}

    public static synchronized PersonComponentDao getInstance() {
        if (instance == null) {
            instance = new PersonComponentDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(PersonComponentDao.class);

    public void flush(Integer id, String newName) throws DaoException {
        try {
            PersonComponent p = (PersonComponent)session.get(PersonComponent.class, id);
            System.out.println(p);
            p.setName(newName);
            System.out.println(p);
            session.flush();
            System.out.println(p);
        } catch (HibernateException e) {
            log.error("Error Flush person" + e);
            throw new DaoException(e);
        }

    }

    public void refresh(Integer id, String newName) throws DaoException {
        try {
            PersonComponent p = (PersonComponent)session.get(PersonComponent.class, id);
            System.out.println(p);
            p.setName(newName);
            System.out.println(p);
            session.refresh(p);
            System.out.println(p);
        } catch (HibernateException e) {
            log.error("Error Refresh person" + e);
            throw new DaoException(e);
        }

    }
}

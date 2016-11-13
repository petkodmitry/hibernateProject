package by.academy.it.db2;

import by.academy.it.pojos2.PersonUnion;
import org.apache.log4j.Logger;

public class PersonUnionDao extends Base2Dao<PersonUnion> {
    private static PersonUnionDao instance;

    private PersonUnionDao() {}

    public static synchronized PersonUnionDao getInstance() {
        if (instance == null) {
            instance = new PersonUnionDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(PersonUnionDao.class);
}

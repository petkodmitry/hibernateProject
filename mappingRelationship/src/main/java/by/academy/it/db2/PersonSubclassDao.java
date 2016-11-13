package by.academy.it.db2;

import by.academy.it.pojos2.PersonSubclass;
import org.apache.log4j.Logger;

public class PersonSubclassDao extends Base2Dao<PersonSubclass> {
    private static PersonSubclassDao instance;

    private PersonSubclassDao() {}

    public static synchronized PersonSubclassDao getInstance() {
        if (instance == null) {
            instance = new PersonSubclassDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(PersonSubclassDao.class);
}

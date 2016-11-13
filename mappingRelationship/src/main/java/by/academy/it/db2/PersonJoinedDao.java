package by.academy.it.db2;

import by.academy.it.pojos2.PersonJoined;
import org.apache.log4j.Logger;

public class PersonJoinedDao extends Base2Dao<PersonJoined> {
    private static PersonJoinedDao instance;

    private PersonJoinedDao() {}

    public static synchronized PersonJoinedDao getInstance() {
        if (instance == null) {
            instance = new PersonJoinedDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(PersonJoinedDao.class);
}

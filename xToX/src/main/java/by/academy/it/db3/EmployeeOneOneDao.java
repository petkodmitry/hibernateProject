package by.academy.it.db3;

import by.academy.it.pojos3.EmployeeOneOne;
import org.apache.log4j.Logger;

public class EmployeeOneOneDao extends Base3Dao<EmployeeOneOne> {
    private static EmployeeOneOneDao instance;

    private EmployeeOneOneDao() {}

    public static synchronized EmployeeOneOneDao getInstance() {
        if (instance == null) {
            instance = new EmployeeOneOneDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(EmployeeOneOneDao.class);
}

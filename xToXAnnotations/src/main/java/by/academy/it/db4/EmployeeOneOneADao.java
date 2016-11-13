package by.academy.it.db4;

import by.academy.it.pojos4.EmployeeOneOneA;
import org.apache.log4j.Logger;

public class EmployeeOneOneADao extends Base4Dao<EmployeeOneOneA> {
    private static EmployeeOneOneADao instance;

    private EmployeeOneOneADao() {}

    public static synchronized EmployeeOneOneADao getInstance() {
        if (instance == null) {
            instance = new EmployeeOneOneADao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(EmployeeOneOneADao.class);
}

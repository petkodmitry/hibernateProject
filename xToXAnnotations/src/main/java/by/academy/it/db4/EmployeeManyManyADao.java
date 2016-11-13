package by.academy.it.db4;

import by.academy.it.pojos4.EmployeeManyManyA;
import org.apache.log4j.Logger;

public class EmployeeManyManyADao extends Base4Dao<EmployeeManyManyA> {
    private static EmployeeManyManyADao instance;

    private EmployeeManyManyADao() {}

    public static synchronized EmployeeManyManyADao getInstance() {
        if (instance == null) {
            instance = new EmployeeManyManyADao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(EmployeeManyManyADao.class);
}

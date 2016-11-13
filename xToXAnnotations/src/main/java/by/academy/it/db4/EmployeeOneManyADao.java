package by.academy.it.db4;

import by.academy.it.pojos4.EmployeeOneManyA;
import org.apache.log4j.Logger;

public class EmployeeOneManyADao extends Base4Dao<EmployeeOneManyA> {
    private static EmployeeOneManyADao instance;

    private EmployeeOneManyADao() {}

    public static synchronized EmployeeOneManyADao getInstance() {
        if (instance == null) {
            instance = new EmployeeOneManyADao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(EmployeeOneManyADao.class);
}

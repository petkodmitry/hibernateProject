package by.academy.it.db3;

import by.academy.it.pojos3.EmployeeOneMany;
import org.apache.log4j.Logger;

public class EmployeeOneManyDao extends Base3Dao<EmployeeOneMany> {
    private static EmployeeOneManyDao instance;

    private EmployeeOneManyDao() {}

    public static synchronized EmployeeOneManyDao getInstance() {
        if (instance == null) {
            instance = new EmployeeOneManyDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(EmployeeOneManyDao.class);
}

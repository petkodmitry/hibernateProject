package by.academy.it.db3;

import by.academy.it.pojos3.EmployeeManyMany;
import org.apache.log4j.Logger;

public class EmployeeManyManyDao extends Base3Dao<EmployeeManyMany> {
    private static EmployeeManyManyDao instance;

    private EmployeeManyManyDao() {}

    public static synchronized EmployeeManyManyDao getInstance() {
        if (instance == null) {
            instance = new EmployeeManyManyDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(EmployeeManyManyDao.class);
}

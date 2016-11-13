package by.academy.it.db2;

import by.academy.it.pojos2.EmployeeJoined;
import org.apache.log4j.Logger;

public class EmployeeJoinedDao extends Base2Dao<EmployeeJoined> {
    private static EmployeeJoinedDao instance;

    private EmployeeJoinedDao() {}

    public static synchronized EmployeeJoinedDao getInstance() {
        if (instance == null) {
            instance = new EmployeeJoinedDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(EmployeeJoinedDao.class);
}

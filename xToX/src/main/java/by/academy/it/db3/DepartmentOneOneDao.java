package by.academy.it.db3;

import by.academy.it.pojos3.DepartmentOneOne;
import org.apache.log4j.Logger;

public class DepartmentOneOneDao extends Base3Dao<DepartmentOneOne> {
    private static DepartmentOneOneDao instance;

    private DepartmentOneOneDao() {}

    public static synchronized DepartmentOneOneDao getInstance() {
        if (instance == null) {
            instance = new DepartmentOneOneDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(DepartmentOneOneDao.class);
}

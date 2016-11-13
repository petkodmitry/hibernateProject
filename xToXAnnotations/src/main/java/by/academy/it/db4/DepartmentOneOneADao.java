package by.academy.it.db4;

import by.academy.it.pojos4.DepartmentOneOneA;
import org.apache.log4j.Logger;

public class DepartmentOneOneADao extends Base4Dao<DepartmentOneOneA> {
    private static DepartmentOneOneADao instance;

    private DepartmentOneOneADao() {}

    public static synchronized DepartmentOneOneADao getInstance() {
        if (instance == null) {
            instance = new DepartmentOneOneADao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(DepartmentOneOneADao.class);
}

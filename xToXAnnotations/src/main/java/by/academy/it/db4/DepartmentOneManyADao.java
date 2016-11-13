package by.academy.it.db4;

import by.academy.it.pojos4.DepartmentOneManyA;
import org.apache.log4j.Logger;

public class DepartmentOneManyADao extends Base4Dao<DepartmentOneManyA> {
    private static DepartmentOneManyADao instance;

    private DepartmentOneManyADao() {}

    public static synchronized DepartmentOneManyADao getInstance() {
        if (instance == null) {
            instance = new DepartmentOneManyADao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(DepartmentOneManyADao.class);
}

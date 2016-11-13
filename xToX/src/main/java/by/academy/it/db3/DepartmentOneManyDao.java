package by.academy.it.db3;

import by.academy.it.pojos3.DepartmentOneMany;
import org.apache.log4j.Logger;

public class DepartmentOneManyDao extends Base3Dao<DepartmentOneMany> {
    private static DepartmentOneManyDao instance;

    private DepartmentOneManyDao() {}

    public static synchronized DepartmentOneManyDao getInstance() {
        if (instance == null) {
            instance = new DepartmentOneManyDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(DepartmentOneManyDao.class);
}

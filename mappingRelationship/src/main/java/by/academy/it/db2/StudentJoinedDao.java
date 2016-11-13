package by.academy.it.db2;

import by.academy.it.pojos2.StudentJoined;
import org.apache.log4j.Logger;

public class StudentJoinedDao extends Base2Dao<StudentJoined> {
    private static StudentJoinedDao instance;

    private StudentJoinedDao() {}

    public static synchronized StudentJoinedDao getInstance() {
        if (instance == null) {
            instance = new StudentJoinedDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(StudentJoinedDao.class);
}

package by.academy.it.db3;

import by.academy.it.pojos3.MeetingManyMany;
import org.apache.log4j.Logger;

public class MeetingManyManyDao extends Base3Dao<MeetingManyMany> {
    private static MeetingManyManyDao instance;

    private MeetingManyManyDao() {}

    public static synchronized MeetingManyManyDao getInstance() {
        if (instance == null) {
            instance = new MeetingManyManyDao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(MeetingManyManyDao.class);
}

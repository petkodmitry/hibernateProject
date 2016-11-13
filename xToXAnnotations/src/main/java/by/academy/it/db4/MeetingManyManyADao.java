package by.academy.it.db4;

import by.academy.it.pojos4.MeetingManyManyA;
import org.apache.log4j.Logger;

public class MeetingManyManyADao extends Base4Dao<MeetingManyManyA> {
    private static MeetingManyManyADao instance;

    private MeetingManyManyADao() {}

    public static synchronized MeetingManyManyADao getInstance() {
        if (instance == null) {
            instance = new MeetingManyManyADao();
        }
        return instance;
    }

    private static Logger log = Logger.getLogger(MeetingManyManyADao.class);
}

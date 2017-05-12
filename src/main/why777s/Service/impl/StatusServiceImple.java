package Service.impl;

import Dao.impl.StatusDaoImpl;
import Entity.Status;
import Service.StatusService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/5/11.
 */
public class StatusServiceImple implements StatusService {
    private StatusDaoImpl statusDao;

    public void setStatusDao(StatusDaoImpl statusDao) {
        this.statusDao = statusDao;
    }

    @Transactional
    public void change_to_zero() {
        Status status = get_Status();
        status.setPermitSelect(0);
        statusDao.update(status);

    }

    @Transactional
    public void change_to_one() {
        Status status = get_Status();
        status.setPermitSelect(1);
        statusDao.update(status);
    }

    @Transactional
    public Status get_Status() {
        String hql ="from Status " +
                "where state=?";
        return statusDao.get(Status.class,"selectCourse");
    }
}

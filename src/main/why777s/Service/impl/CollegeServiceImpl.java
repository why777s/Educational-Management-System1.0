package Service.impl;

import Dao.impl.CollegeDaoImpl;
import Entity.College;
import Service.CollegeService;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by wangzhaojun on 2017/5/12.
 */
public class CollegeServiceImpl implements CollegeService {
    private CollegeDaoImpl collegeDao;


    public void setCollegeDao(CollegeDaoImpl collegeDao) {
        this.collegeDao = collegeDao;
    }

    @Transactional
    public College get_college(String yxh) {
        return collegeDao.get(College.class,yxh);
    }
}

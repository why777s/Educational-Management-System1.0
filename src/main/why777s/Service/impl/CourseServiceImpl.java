package Service.impl;

import Dao.impl.CourseDaoImpl;
import Entity.Course;
import Service.CourseService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/19.
 */
public class CourseServiceImpl implements CourseService {
    private CourseDaoImpl courseDao;


    public void setCourseDao(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }

    @Transactional
    public List<Course> get_all() {
        return courseDao.findall(Course.class);
    }
}

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

    @Transactional
    public Course get_Course(String cid) {
        return  courseDao.get(Course.class,cid);
    }

    @Transactional
    public void update_c(Course course) {
        courseDao.update(course);
    }

    @Transactional
    public void setCourseDao(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }

    @Transactional
    public List<Course> get_all() {
        return courseDao.findall(Course.class);
    }


    @Transactional
    public String save_c(Course course) {
        return (String)courseDao.save(course);
    }
}

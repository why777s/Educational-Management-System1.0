package Service;

import Entity.Course;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/19.
 */
public interface CourseService {
    List<Course> get_all();
    Course get_Course(String cid);
    void update_c(Course course);
    String save_c(Course course);

}

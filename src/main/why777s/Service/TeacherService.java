package Service;

import Entity.SelectCourse;
import Entity.Teacher;
import Entity.multiQuery.Course_OpenCourse_cid;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/24.
 */
public interface TeacherService {
    boolean login(Teacher teacher);
    List<Course_OpenCourse_cid> get_tkaike_info();
    List<SelectCourse> get_txk_info();
}

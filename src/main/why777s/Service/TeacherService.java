package Service;

import Entity.OpenCourse;
import Entity.SelectCourse;
import Entity.Teacher;
import Entity.multiQuery.Course_OpenCourse_cid;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/24.
 */
public interface TeacherService {
    boolean login(Teacher teacher);
//    List<Course_OpenCourse_cid> get_tkaike_info();
    List<OpenCourse> get_tkaike_info_oc();
    List<SelectCourse> get_txk_info();
    List<Teacher> getallTea();
    Teacher get_tea(String tid);
    void update_tea(Teacher teacher);


    List<SelectCourse> get_txk_info(String cid);

}

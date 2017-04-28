package Service;

import Entity.OpenCourse;
import Entity.multiQuery.Course_OpenCourse_cid;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/19.
 */
public interface OpenCourseService {
    //获得所有实体
    List<OpenCourse> get_all();

    //选课表（详细的开课信息）
    List<Course_OpenCourse_cid> get_all_inf();

}

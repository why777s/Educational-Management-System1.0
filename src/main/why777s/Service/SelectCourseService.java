package Service;

import Entity.SelectCourse;
import Entity.SelectCoursePK;
import Entity.multiQuery.sC_C_T;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/21.
 */
public interface SelectCourseService {
    //选课
    SelectCoursePK save(SelectCourse selectCourse);

    //获取所有实体
    List<SelectCourse> get_all();

    //查询当前已选课程
    List<sC_C_T> get_all_inf();

    //查询当前登录学生的选修信息
    List<SelectCourse> get_all_ById();

    void deletedelete(SelectCoursePK selectCoursePK);

    SelectCourse get_selectCourse(SelectCoursePK selectCoursePK);

    boolean timeConflict(String time,String id);




}

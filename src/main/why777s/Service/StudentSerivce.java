package Service;

import Entity.Student;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public interface StudentSerivce {
    boolean login(Student student);
    Student get_stu(String id);
    void update_stu(Student student);

    // 返回所有学生对象（admin用到）
    List<Student> getallstu();

    //学生选课 相当于 selectCourse表的保存
    //学生id + openCourse表 可以成为一个selectCourse对象
}

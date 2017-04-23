package Service;

import Entity.Student;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public interface StudentSerivce {
    boolean login(Student student);

    //学生选课 相当于 selectCourse表的保存
    //学生id + openCourse表 可以成为一个selectCourse对象





}

package Service.impl;

import Dao.impl.StudentDaoImpl;
import Entity.Student;
import Service.StudentSerivce;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class StudentServiceImpl implements StudentSerivce {
    private StudentDaoImpl studentDao;

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }


    //学生登录
    @Transactional
    public boolean login(Student student) {
        Student stu = studentDao.get(Student.class,student.getSid());
        if (stu==null){
            System.out.println("学号为"+student.getSid()+"的同学不存在");
            return false;
        }
        else {
            System.out.println(stu);
            System.out.println("该学生基本信息：");
            System.out.println(stu.getSid());
            System.out.println(stu.getSname());
            System.out.println(stu.getCollegeByYxh());
            return stu.getPassword().equals(student.getPassword());
        }
    }
}

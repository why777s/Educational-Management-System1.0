package Service.impl;

import Dao.impl.StudentDaoImpl;
import Entity.Student;
import Service.StudentSerivce;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;
import other.MD5;

import javax.transaction.Transaction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class StudentServiceImpl implements StudentSerivce {
    private StudentDaoImpl studentDao;

    public void setStudentDao(StudentDaoImpl studentDao) {
        this.studentDao = studentDao;
    }

    //调用存储过程
    @Transactional
    public void addTuitionProc(String ssid,int cc){
        Session session = studentDao.getSessionFactory().getCurrentSession();
        Query query = session.createSQLQuery("{call add_tuition_proc(?,?)}");
        query.setParameter(0,ssid);
        query.setParameter(1,cc);
        query.executeUpdate();
    }

    @Transactional
    public void subTuitionProc(String ssid,int cc){
        Session session = studentDao.getSessionFactory().getCurrentSession();
        Query query = session.createSQLQuery("{call sub_tuition_proc(?,?)}");
        query.setParameter(0,ssid);
        query.setParameter(1,cc);
        query.executeUpdate();
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
            try{
                String new_str = new MD5().getMD5(student.getPassword());
                if (new_str.equals(stu.getPassword()))
                    return true;
            }catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }
    }
    @Transactional
    public Student get_stu(String id) {
        return studentDao.get(Student.class,id);
    }

    @Transactional
    public void update_stu(Student student) {
        studentDao.update(student);
    }

    //返回所有学生
    @Transactional
    public List<Student> getallstu() {
        return studentDao.findall(Student.class);
    }
}

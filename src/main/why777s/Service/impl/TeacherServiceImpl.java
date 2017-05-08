package Service.impl;

import Dao.impl.*;
import Entity.SelectCourse;
import Entity.Teacher;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.TeacherService;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/24.
 */
public class TeacherServiceImpl implements TeacherService {
    private TeacherDaoImpl teacherDao;
    private Course_OpenCourse_DaoImpl course_openCourse_dao;
    private SelectCourseDaoImpl selectCourseDao;

    public void setCourse_openCourse_dao(Course_OpenCourse_DaoImpl course_openCourse_dao) {
        this.course_openCourse_dao = course_openCourse_dao;
    }

    public void setSelectCourseDao(SelectCourseDaoImpl selectCourseDao) {
        this.selectCourseDao = selectCourseDao;
    }

    public void setTeacherDao(TeacherDaoImpl teacherDao) {
        this.teacherDao = teacherDao;
    }

    @Transactional
    public boolean login(Teacher teacher) {
        Teacher tc = teacherDao.get(Teacher.class,teacher.getTid());
        if (tc==null){
            System.out.println("工号为"+teacher.getTid()+"的教师不存在");
            return false;
        }
        else {
            System.out.println("欢迎工号为"+teacher.getTid()+"的教师");
            return tc.getPassword().equals(teacher.getPassword());
        }
    }

    //教师查询自己的开课情况
    @Transactional
    public List<Course_OpenCourse_cid> get_tkaike_info() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String boomshakalaka = (String)session.getAttribute("userID");
        System.out.println("当前职工号:"+boomshakalaka);
            String hql="select new Entity.multiQuery.Course_OpenCourse_cid(x.cid,x.time,x.semester,y.cname,y.ccredit,x.tid) " +
                "from OpenCourse x,Course y " +
                "where x.cid=y.cid and x.tid=? ";
        return course_openCourse_dao.find_withOnePara(hql,boomshakalaka);
    }

    //登分 查询开课表
    @Transactional
    public List<SelectCourse> get_txk_info(){
        HttpSession session = ServletActionContext.getRequest().getSession();
        String asd = (String)session.getAttribute("userID");
        System.out.println("当前职工号啊啊啊啊！:"+asd);
//        String hql ="from SelectCourse " +
//                "select sid,cid,pscj " +
//                "where tid=?";
        String hql = "from SelectCourse where tid=?";
        return selectCourseDao.find_withOnePara(hql,asd);
    }



    @Transactional
    public List<Teacher> getallTea() {
        return teacherDao.findall(Teacher.class);
    }
}

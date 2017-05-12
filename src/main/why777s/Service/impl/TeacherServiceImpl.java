package Service.impl;

import Dao.impl.*;
import Entity.Course;
import Entity.OpenCourse;
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
    private CourseDaoImpl courseDao;
    private OpenCourseDaoImpl openCourseDao;

    public void setOpenCourseDao(OpenCourseDaoImpl openCourseDao) {
        this.openCourseDao = openCourseDao;
    }

    public void setCourseDao(CourseDaoImpl courseDao) {
        this.courseDao = courseDao;
    }

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

//    //教师查询自己的开课情况
//    @Transactional
//    public List<Course_OpenCourse_cid> get_tkaike_info() {
//        HttpSession session = ServletActionContext.getRequest().getSession();
//        String boomshakalaka = (String)session.getAttribute("userID");
//        System.out.println("当前职工号:"+boomshakalaka);
//            String hql="select new Entity.multiQuery.Course_OpenCourse_cid(x.cid,x.time,x.semester,y.cname,y.ccredit,x.tid) " +
//                "from OpenCourse x,Course y " +
//                "where x.cid=y.cid and x.tid=? ";
//        return course_openCourse_dao.find_withOnePara(hql,boomshakalaka);
//    }




    @Transactional
    public List<OpenCourse> get_tkaike_info_oc() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String tid1 = (String)session.getAttribute("userID");
        System.out.println("当前职工号:"+tid1);
        String hql = "from OpenCourse where tid=?";
        return openCourseDao.find_withOnePara(hql,tid1);
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
    public Teacher get_tea(String tid) {
        return teacherDao.get(Teacher.class,tid);
    }

    @Transactional
    public void update_tea(Teacher teacher) {
        teacherDao.update(teacher);
    }

    @Transactional
    public List<Teacher> getallTea() {
        return teacherDao.findall(Teacher.class);
    }

    //查询某老师某门课的开课情况
    @Transactional
    public List<SelectCourse> get_txk_info(String cid){
        HttpSession session = ServletActionContext.getRequest().getSession();
        String asd = (String)session.getAttribute("userID");
        System.out.println("当前职工号:"+asd);
        String hql = "from SelectCourse where tid=? and cid=?";
//        教师号和课程号确定该老师这门课的选课情况
        return selectCourseDao.find_withTwoPara(hql,asd,cid);
    }
    //更新成绩比例
    @Transactional
    public void update_c_bl(Course c){
        courseDao.update(c);
    }
    //登分操作
    @Transactional
    public void update_tc_sc(SelectCourse tc_df){
        selectCourseDao.update(tc_df);
    }

}

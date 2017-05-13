package Controller;

import Dao.impl.OpenCourseDaoImpl;
import Dao.impl.SelectCourseDaoImpl;
import Entity.*;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.CourseService;
import Service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/21.
 */
public class FuncAction extends ActionSupport {
    private Course_OpenCourse_cid kklist;
    private SelectCourseServiceImpl selectCourseService;
    private OpenCourseDaoImpl openCourseDao;
    private TeacherServiceImpl teacherService;
    private OpenCourseServiceImpl openCourseService;
    private SelectCourseDaoImpl selectCourseDao;
    public List<Course_OpenCourse_cid> course_openCourse_cids;
    public List<OpenCourse> stu_openCourseList;
    private StudentServiceImpl studentService;
    private CourseService courseService;
    private String setopen;

    private StatusServiceImple statusServiceImple;

    public void setStatusServiceImple(StatusServiceImple statusServiceImple) {
        this.statusServiceImple = statusServiceImple;
    }

    public String getSetopen() {
        return setopen;
    }

    public void setSetopen(String setopen) {
        this.setopen = setopen;
    }

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<SelectCourse> scList;

    public List<String>  jieshoudecid;
    public List<String> jieshoudecname;
    public int jieshoudexuhao;

    public int getJieshoudexuhao() {
        return jieshoudexuhao;
    }

    public void setJieshoudexuhao(int jieshoudexuhao) {
        this.jieshoudexuhao = jieshoudexuhao;
    }

    public List<String> getJieshoudecid() {
        return jieshoudecid;
    }

    public void setJieshoudecid(List<String> jieshoudecid) {
        this.jieshoudecid = jieshoudecid;
    }

    public List<String> getJieshoudecname() {
        return jieshoudecname;
    }

    public void setJieshoudecname(List<String> jieshoudecname) {
        this.jieshoudecname = jieshoudecname;
    }

    public Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<SelectCourse> getScList() {
        return scList;
    }

    public void setScList(List<SelectCourse> scList) {
        this.scList = scList;
    }

    public String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    private SelectCourse tklist;

    public SelectCourse getTklist() {
        return tklist;
    }

    public void setTklist(SelectCourse tklist) {
        this.tklist = tklist;
    }

    public SelectCourseDaoImpl getSelectCourseDao() {
        return selectCourseDao;
    }

    public void setSelectCourseDao(SelectCourseDaoImpl selectCourseDao) {
        this.selectCourseDao = selectCourseDao;
    }

    public OpenCourseServiceImpl getOpenCourseService() {
        return openCourseService;
    }

    public void setOpenCourseService(OpenCourseServiceImpl openCourseService) {
        this.openCourseService = openCourseService;
    }

    public TeacherServiceImpl getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    public List<Course_OpenCourse_cid> getCourse_openCourse_cids() {
        return course_openCourse_cids;
    }

    public void setCourse_openCourse_cids(List<Course_OpenCourse_cid> course_openCourse_cids) {
        this.course_openCourse_cids = course_openCourse_cids;
    }

    public OpenCourseDaoImpl getOpenCourseDao() {
        return openCourseDao;
    }

    public void setOpenCourseDao(OpenCourseDaoImpl openCourseDao) {
        this.openCourseDao = openCourseDao;
    }

    public Course_OpenCourse_cid getKklist() {
        return kklist;
    }

    public void setKklist(Course_OpenCourse_cid kklist) {
        this.kklist = kklist;
    }

    public SelectCourseServiceImpl getSelectCourseService() {
        return selectCourseService;
    }

    public void setSelectCourseService(SelectCourseServiceImpl selectCourseService) {
        this.selectCourseService = selectCourseService;
    }
    //action分得不好，选课一直是同一张开课表，无需改变，则无需重复查询
    public List<OpenCourse> getStu_openCourseList() {
        return stu_openCourseList;
    }
    public void setStu_openCourseList(List<OpenCourse> stu_openCourseList) {
        this.stu_openCourseList = stu_openCourseList;
    }

    // 退课
    public String tuike() throws Exception{
        System.out.println("准备退课");
        System.out.println(tklist.getSid());
        System.out.println(tklist.getTid());

        SelectCoursePK selectCoursePK = new SelectCoursePK();
        HttpSession session = ServletActionContext.getRequest().getSession();
        selectCoursePK.setSid((String)session.getAttribute("userID"));
        selectCoursePK.setTid(tklist.getTid());
        selectCoursePK.setCid(tklist.getCid());
        selectCoursePK.setSemester("2016-2017 春");

        try{
            SelectCourse selectCourse1 = selectCourseService.get_selectCourse(selectCoursePK);
            Student student = studentService.get_stu((String)session.getAttribute("userID"));
            System.out.println("学生本来学分："+student.getScredit());
            student.setScredit(student.getScredit()-selectCourse1.getCourseByCid().getCcredit());
            System.out.println("退课后的学分:"+student.getScredit());
            studentService.update_stu(student);

            selectCourseService.deletedelete(selectCoursePK);
            scList = selectCourseService.get_all_ById();
        }catch (Exception e){
            e.printStackTrace();
            message = "退课失败";
        }
        message="退课成功";
        return SUCCESS;
    }


    //选课
    public String xuanke() throws Exception {
        System.out.println("准备选课处理");
        //获取web Sesssion
        HttpSession session = ServletActionContext.getRequest().getSession();
        String ssid = (String)session.getAttribute("userID");
        //获取开课表所需填入选课表
        SelectCourse selectCourse = new SelectCourse();
        selectCourse.setSid((String)session.getAttribute("userID"));
        selectCourse.setTid(kklist.getTid());
        selectCourse.setSemester("2016-2017 春");
        selectCourse.setCid(kklist.getCid());
        //？有何用？复合主键的单独表？
        SelectCoursePK selectCoursePK = new SelectCoursePK();
        selectCoursePK.setSid((String)session.getAttribute("userID"));
        selectCoursePK.setTid(kklist.getTid());
        selectCoursePK.setCid(kklist.getCid());
        selectCoursePK.setSemester("2016-2017 春");

        System.out.println("开始选课处理！！！");
        System.out.println(selectCourse.getSemester());
        System.out.println(selectCourse.getSid());
        System.out.println(selectCourse.getCid());
        System.out.println(selectCourse.getTid());
        System.out.println("以上为要保存的选课信息");

//        course_openCourse_cids = openCourseService.get_all_inf();
        if (!selectCourseService.timeConflict(kklist.getTime(),ssid)){
            message = "时间冲突或重复选课!";
            return ERROR;
        }
        try {
            selectCourseService.save(selectCourse);
            //计分
            SelectCourse selectCourse1 = selectCourseService.get_selectCourse(selectCoursePK);
            Student student = studentService.get_stu((String)session.getAttribute("userID"));
            System.out.println("学生本来学分："+student.getScredit());
            System.out.println(selectCourse1.getCourseByCid().getCcredit());
            student.setScredit(student.getScredit()+selectCourse1.getCourseByCid().getCcredit());
            System.out.println("选课后的学分:"+student.getScredit());
            studentService.update_stu(student);
        }catch (Exception e){
            e.printStackTrace();
            message = "选课失败";
            return ERROR;
        }
        //再次查询，避开了触发器后需要flush和refresh更新session里的值
        stu_openCourseList=openCourseService.get_all();
        message="选课成功";
        return SUCCESS;
    }



    public String setoepnornot() throws Exception{
        if (getSetopen().equals("开放选课")){
            statusServiceImple.change_to_one();
            message="选课开放成功！";
        }
        if (getSetopen().equals("关闭选课")){
            statusServiceImple.change_to_zero();
            message="选课关闭成功！";
        }
        return SUCCESS;
    }

}

package Controller;

import Entity.*;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.AdminService;
import Service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import Entity.multiQuery.sC_C_T;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/19.
 */
public class NavigateAction extends ActionSupport {
    private CourseServiceImpl courseService;
    private OpenCourseServiceImpl openCourseService;
    private SelectCourseServiceImpl selectCourseService;
    private TeacherServiceImpl teacherService;
    private StudentServiceImpl studentService;
    private AdminService adminService;
    private StatusServiceImple statusServiceImple;

    public void setStatusServiceImple(StatusServiceImple statusServiceImple) {
        this.statusServiceImple = statusServiceImple;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    private Student me;
    private Admin admin;
    private Teacher teacher;


    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Student getMe() {
        return me;
    }

    public void setMe(Student me) {
        this.me = me;
    }

    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    public void setTeacherService(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    public SelectCourseServiceImpl getSelectCourseService() {
        return selectCourseService;
    }

    public void setSelectCourseService(SelectCourseServiceImpl selectCourseService) {
        this.selectCourseService = selectCourseService;
    }


    public List<Course> courseList;
    public List<OpenCourse> openCourseList;
    public List<Course_OpenCourse_cid> course_openCourse_cids;
    public List<sC_C_T> sC_c_ts;
    public List<SelectCourse> scList;
    public List<Student> studentList;
    public List<Teacher> teacherList;

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<SelectCourse> getScList() {
        return scList;
    }

    public void setScList(List<SelectCourse> scList) {
        this.scList = scList;
    }

    public List<Course_OpenCourse_cid> getCourse_openCourse_cids() {
        return course_openCourse_cids;
    }

    public void setCourse_openCourse_cids(List<Course_OpenCourse_cid> course_openCourse_cids) {
        this.course_openCourse_cids = course_openCourse_cids;
    }

    public CourseServiceImpl getCourseService() {
        return courseService;
    }

    public void setCourseService(CourseServiceImpl courseService) {
        this.courseService = courseService;
    }

    public OpenCourseServiceImpl getOpenCourseService() {
        return openCourseService;
    }

    public void setOpenCourseService(OpenCourseServiceImpl openCourseService) {
        this.openCourseService = openCourseService;
    }



    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<OpenCourse> getOpenCourseList() {
        return openCourseList;
    }

    public void setOpenCourseList(List<OpenCourse> openCourseList) {
        this.openCourseList = openCourseList;
    }

    @Override
    public String execute() throws Exception {
        courseList = courseService.get_all();
        return SUCCESS;
    }

    //跳转到选课页面
    public String turnSc() throws Exception{
        course_openCourse_cids = openCourseService.get_all_inf();
        if (statusServiceImple.get_Status().getPermitSelect()==0){
            return ERROR;
        }
        else
            return SUCCESS;
    }

    // 查看学生个人信息
    public String schedule() throws Exception{
        HttpSession session = ServletActionContext.getRequest().getSession();
        sC_c_ts = selectCourseService.get_all_inf();
        me = studentService.get_stu((String)session.getAttribute("userID"));
        return SUCCESS;
    };

    //处理 教师查看个人开课情况 跳转Action
    public String turnTschedu() throws Exception{
        openCourseList = teacherService.get_tkaike_info_oc();
        return SUCCESS;
    };

    //处理 教师登分 跳转Action
    public String turnEntry() throws Exception{
        openCourseList = teacherService.get_tkaike_info_oc();
        return SUCCESS;
    }

    //退课
    public String turnTk() throws Exception{
        scList = selectCourseService.get_all_ById();
        if (statusServiceImple.get_Status().getPermitSelect()==0){
            return ERROR;
        }
        else
            return SUCCESS;
    }

    //查看所有学生信息 Action
    public String turnStuInfo() throws Exception{
        studentList = studentService.getallstu();
        return SUCCESS;
    }


    //当前管理员个人信息Action
    public String turnAdInfo() throws Exception{
         admin = adminService.getAdminInfo();
        return SUCCESS;
    }

    //管理员看教师信息 action
    public String turnTeaInfo() throws Exception{
        teacherList = teacherService.getallTea();
        return SUCCESS;
    }

    public String turnkf() throws Exception{
        return SUCCESS;
    }


    public String adminturnxgtea() throws Exception{
        teacherList = teacherService.getallTea();
        return SUCCESS;
    }



    //某教师某门课的选课情况
    private  String tc_downmenu_cid;
    public String getTc_downmenu_cid() {
        return tc_downmenu_cid;
    }
    public void setTc_downmenu_cid(String tc_downmenu_cid) {
        this.tc_downmenu_cid = tc_downmenu_cid;
    }


    //成绩比例
    //dfbl为修改后，dfbl_Old为修改前
    private Float dfbl_Old;
    public Float getDfbl_Old() {return dfbl_Old;}
    public void setDfbl_Old(Float dfbl_Old) {this.dfbl_Old = dfbl_Old;}
    private Float dfbl;
    public Float getDfbl() {return dfbl;}
    public void setDfbl(Float dfbl) {this.dfbl = dfbl;}
    //某教师某门课的登分表,分登分前后
    private List<SelectCourse> tc_scList;
    public List<SelectCourse> getTc_scList() {
        return tc_scList;
    }
    public void setTc_scList(List<SelectCourse> tc_scList) {
        this.tc_scList = tc_scList;
    }
    //整体保存登分，平时成绩和课时成绩的list
    private List<String> pscj_list;
    public List<String> getPscj_list() {return pscj_list;}
    public void setPscj_list(List<String> pscj_list) {this.pscj_list = pscj_list;}
    private List<String> kscj_list;
    public List<String> getKscj_list() {return kscj_list;}
    public void setKscj_list(List<String> kscj_list) {this.kscj_list = kscj_list;}


    //更新该门课的成绩比例（平时成绩/总评成绩）
    public String updatedfbl() throws Exception{
        Course c=tc_scList.get(0).getCourseByCid();
        c.setBl(dfbl);
        teacherService.update_c_bl(c);
        dfbl_Old=c.getBl();
        //修改比例后更新总评成绩
        DecimalFormat decimalFormat=new DecimalFormat(".0");
        int i=0;
        for (SelectCourse df: tc_scList) {
            df.setZpcj(decimalFormat.format(dfbl_Old * Integer.valueOf(df.getPscj()) + (1 - dfbl_Old) * Integer.valueOf(df.getKscj())));
            i++;
            teacherService.update_tc_sc(df);
        }
        return SUCCESS;
    }
    //查看某教师某门课的选课情况
    public String turnTC() throws Exception{
        //  教师某门课的选课情况
        tc_scList = teacherService.get_txk_info(getTc_downmenu_cid());
        //成绩比例
        dfbl_Old=tc_scList.get(0).getCourseByCid().getBl();
        return SUCCESS;
    }

    //某教师某门课的整体登分action
    public String TCdf() throws Exception{
        DecimalFormat decimalFormat=new DecimalFormat(".0");
        int i=0;
        for (SelectCourse df: tc_scList) {
            df.setPscj(pscj_list.get(i));
            df.setKscj(kscj_list.get(i));
            df.setZpcj(decimalFormat.format(dfbl_Old * Integer.valueOf(df.getPscj()) + (1 - dfbl_Old) * Integer.valueOf(df.getKscj())));
            i++;
            teacherService.update_tc_sc(df);
        }
        return SUCCESS;
    }


}

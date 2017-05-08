package Controller;

import Entity.*;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.AdminService;
import Service.impl.*;
import com.opensymphony.xwork2.ActionSupport;
import Entity.multiQuery.sC_C_T;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
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
        course_openCourse_cids = teacherService.get_tkaike_info();
        return SUCCESS;
    };

    //处理 教师登分 跳转Action
    public String turnEntry() throws Exception{
        scList = teacherService.get_txk_info();
        course_openCourse_cids = teacherService.get_tkaike_info();
        return SUCCESS;
    }

    //退课
    public String turnTk() throws Exception{
        scList = selectCourseService.get_all_ById();
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


}

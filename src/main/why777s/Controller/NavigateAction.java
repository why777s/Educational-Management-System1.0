package Controller;

import Dao.impl.CourseDaoImpl;
import Entity.Course;
import Entity.OpenCourse;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.impl.CourseServiceImpl;
import Service.impl.OpenCourseServiceImpl;
import Service.impl.SelectCourseServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import Entity.multiQuery.sC_C_T;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/19.
 */
public class NavigateAction extends ActionSupport {
    private CourseServiceImpl courseService;
    private OpenCourseServiceImpl openCourseService;
    private SelectCourseServiceImpl selectCourseService;

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

    public String turnSc() throws Exception{
//        openCourseList = openCourseService.get_all();
        course_openCourse_cids = openCourseService.get_all_inf();
        return SUCCESS;
    }

    public String schedule() throws Exception{
        sC_c_ts = selectCourseService.get_all_inf();
        return SUCCESS;
    };

}

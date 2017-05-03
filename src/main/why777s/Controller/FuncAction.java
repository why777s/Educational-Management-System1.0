package Controller;

import Dao.impl.OpenCourseDaoImpl;
import Dao.impl.SelectCourseDaoImpl;
import Entity.OpenCourse;
import Entity.SelectCourse;
import Entity.SelectCoursePK;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.impl.OpenCourseServiceImpl;
import Service.impl.SelectCourseServiceImpl;
import Service.impl.TeacherServiceImpl;
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

        selectCourseService.deletedelete(selectCoursePK);
        return SUCCESS;
    }








    //选课
    public String xuanke() throws Exception {
        System.out.println("准备选课处理");
        //获取web Sesssion
        HttpSession session = ServletActionContext.getRequest().getSession();

        SelectCourse selectCourse = new SelectCourse();

        selectCourse.setSid((String)session.getAttribute("userID"));
        selectCourse.setTid(kklist.getTid());
        selectCourse.setSemester("2016-2017 春");
        selectCourse.setCid(kklist.getCid());


//
//        SelectCoursePK selectCoursePK = new SelectCoursePK();
//        selectCoursePK.setSid((String)session.getAttribute("userID"));
//        selectCoursePK.setTid(kklist.getTid());
//        selectCoursePK.setCid(kklist.getCid());
//        selectCoursePK.setSemester("2016-2017 春");
            System.out.println("开始选课处理！！！");
        System.out.println(selectCourse.getSemester());
        System.out.println(selectCourse.getSid());
        System.out.println(selectCourse.getCid());
        System.out.println(selectCourse.getTid());
        System.out.println("以上为要保存的选课信息");


        course_openCourse_cids = openCourseService.get_all_inf();

        try {
            selectCourseService.save(selectCourse);
        }catch (Exception e){
            e.printStackTrace();
//            this.addActionMessage("选课失败");
            return ERROR;
        }
        return SUCCESS;
    }
}

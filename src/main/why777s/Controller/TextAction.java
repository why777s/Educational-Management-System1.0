package Controller;

import Entity.College;
import Entity.Course;
import Service.CollegeService;
import Service.CourseService;
import Service.impl.CourseServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/5/12.
 */
public class TextAction extends ActionSupport {
    public List<String> jieshoudecid;
    public List<String> jieshoudecname;
    public String  jieshoudexuhao;
    public Course course;
    public List<Course> courseList;

    private CollegeService collegeService;

    public void setCollegeService(CollegeService collegeService) {
        this.collegeService = collegeService;
    }
    public College college;

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    private String cname;
    private String cid;
    private int ccredit;
    private String yxh;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getCcredit() {
        return ccredit;
    }

    public void setCcredit(int ccredit) {
        this.ccredit = ccredit;
    }

    public String getYxh() {
        return yxh;
    }

    public void setYxh(String yxh) {
        this.yxh = yxh;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String message=null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private CourseService courseService;

    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
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

    public String  getJieshoudexuhao() {
        return jieshoudexuhao;
    }

    public void setJieshoudexuhao(String jieshoudexuhao) {
        this.jieshoudexuhao = jieshoudexuhao;
    }


    @Override
    public String execute() throws Exception {
        message = null;
        return SUCCESS;
    }

    public String gaixuefen() throws Exception{


        System.out.println("要修改的课程名：");
        System.out.println(getJieshoudecid());
        System.out.println(getJieshoudecname());
        for (int i=0;i<getJieshoudecid().size();i++) {
            course = courseService.get_Course(getJieshoudecid().get(i));
            try {
                System.out.println("更改的后的课程名");
                System.out.println(getJieshoudecname().get(i));
                course.setCname(getJieshoudecname().get(i));
                courseService.update_c(course);
                courseList=courseService.get_all();

            } catch (Exception e) {
                e.printStackTrace();
                message = "课程名修改失败！";
                return ERROR;
            }
        }
        message="课程名修改成功";
        return SUCCESS;
    }

    public String adddCourse() throws Exception{
        Course course = new Course();
        course.setCid(getCid());
        course.setCname(getCname());
        course.setCcredit(getCcredit());
        college = collegeService.get_college(getYxh());
//        System.out.println(college.getYxh());
//        System.out.println(college.getYname());
        course.setCollegeByYxh(college);
        course.setYxh(college);
        try{
            courseService.save_c(course);
        }catch (Exception e){
            e.printStackTrace();
            message="插入课程失败";
        }
        message="插入课程成功";
        return SUCCESS;

    }

}

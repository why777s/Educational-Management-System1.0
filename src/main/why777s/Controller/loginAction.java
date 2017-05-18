package Controller;

import Entity.Admin;
import Entity.Student;
import Entity.Teacher;
import Service.impl.AdminServiceImpl;
import Service.impl.StudentServiceImpl;
import Service.impl.TeacherServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.SessionFactory;

import javax.security.auth.login.Configuration;
import java.util.Map;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class loginAction extends ActionSupport {
    private String userID;
    private String password;
    private StudentServiceImpl studentService;
    private TeacherServiceImpl teacherService;
    private AdminServiceImpl adminService;

    public AdminServiceImpl getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    public void setTeacherService(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    public void setStudentService(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //这个没用到的不用管
    @Override
    public String execute() throws Exception {
        if (getUserID().equals("admin")){
            return SUCCESS;
        }else
            return ERROR;
    }

    public String teacherLogin() throws Exception{
        Teacher teacher = new Teacher();
        teacher.setTid(getUserID());
        teacher.setPassword(getPassword());
        if (teacherService.login(teacher)){
            ActionContext actionContext = ActionContext.getContext();
            Map<String,Object> session = actionContext.getSession();
            session.put("userID",teacher.getTid());
            return SUCCESS;
        }else
            return ERROR;
    }

    public String studentLogin() throws Exception{
        Student student = new Student();
        student.setSid(getUserID());
        student.setPassword(getPassword());
        if (studentService.login(student)){
            // 将用户登录的ID存到session中
//            HttpSession session = ServletActionContext.getRequest().getSession();
//            session.setAttribute("userID",student.getSid());
//            session.getAttribute("userID");
            //新建一个session
            ActionContext actionContext = ActionContext.getContext();
            Map<String,Object> session = actionContext.getSession();
            session.put("userID",student.getSid());





            return SUCCESS;
        }
        else
            return ERROR;
    }

    public String adminLogin() throws Exception{
        Admin admin = new Admin();
        admin.setAdminId(getUserID());
        admin.setPassword(getPassword());
        if (adminService.login(admin)){
            ActionContext actionContext = ActionContext.getContext();
            Map<String,Object> session = actionContext.getSession();
            session.put("userID",admin.getAdminId());
            return SUCCESS;
        }
        else
            return ERROR;
    }


}

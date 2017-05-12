package Controller;

import Entity.Teacher;
import Service.impl.TeacherServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by wangzhaojun on 2017/5/12.
 */
public class AdminChangeTeaAction extends ActionSupport {

    private List<String> jieshoudetid;
    private List<String> newtname;
    private List<String> newtitle;
    private List<Integer> newsalary;


    public List<Teacher> teacherList;

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public String message= null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private TeacherServiceImpl teacherService;


    public void setTeacherService(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    public List<Integer> getNewsalary() {
        return newsalary;
    }

    public void setNewsalary(List<Integer> newsalary) {
        this.newsalary = newsalary;
    }

    public List<String> getJieshoudetid() {
        return jieshoudetid;
    }

    public void setJieshoudetid(List<String> jieshoudetid) {
        this.jieshoudetid = jieshoudetid;
    }

    public List<String> getNewtname() {
        return newtname;
    }

    public void setNewtname(List<String> newtname) {
        this.newtname = newtname;
    }

    public List<String> getNewtitle() {
        return newtitle;
    }

    public void setNewtitle(List<String> newtitle) {
        this.newtitle = newtitle;
    }


    public String changeteainf() throws Exception{
        System.out.println(getJieshoudetid());
        System.out.println(getNewtname());
        System.out.println(getNewsalary());
        System.out.println(getNewtitle());
        for (int i=0;i<jieshoudetid.size();i++){
            Teacher teacher = teacherService.get_tea(getJieshoudetid().get(i));
            teacher.setTname(getNewtname().get(i));
            teacher.setSalary(getNewsalary().get(i));
            teacher.setTitle(getNewtitle().get(i));
            try{
                teacherService.update_tea(teacher);
                message = "教师信息修改成功";
                teacherList = teacherService.getallTea();

            }catch (Exception e){
                e.printStackTrace();
                message = "教师信息修改失败";
                return ERROR;
            }
        }
        return SUCCESS;
    }
}

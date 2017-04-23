package Controller;

import Dao.impl.SelectCourseDaoImpl;
import Entity.SelectCourse;
import Entity.SelectCoursePK;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.impl.SelectCourseServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Select;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/21.
 */
public class SelectCourseAction extends ActionSupport {
    private Course_OpenCourse_cid kklist;
    private SelectCourseServiceImpl selectCourseService;



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

    @Override
    public String execute() throws Exception {

        //获取web Sesssion
        HttpSession session = ServletActionContext.getRequest().getSession();


        SelectCourse selectCourse = new SelectCourse();

        selectCourse.setSid((String)session.getAttribute("userID"));
        selectCourse.setTid(kklist.getTid());
        selectCourse.setSemester(kklist.getSemester());
        selectCourse.setCid(kklist.getCid());

//        SelectCoursePK selectCoursePK = new SelectCoursePK();

//        selectCoursePK.setSid((String)session.getAttribute("userID"));
//        selectCoursePK.setTid(kklist.getTid());
//        selectCoursePK.setCid(kklist.getCid());
//        selectCoursePK.setSemester(kklist.getSemester());

//        selectCourse.setSelectCoursePK(selectCoursePK);

         selectCourseService.save(selectCourse);


        System.out.println("开始选课处理！！！");
        return SUCCESS;
    }
}

package Service.impl;

import Dao.BaseDao;
import Dao.BaseDaoFunc;
import Dao.impl.Course_OpenCourse_DaoImpl;
import Dao.impl.OpenCourseDaoImpl;
import Entity.Course;
import Entity.OpenCourse;
import Entity.multiQuery.Course_OpenCourse_cid;
import Service.CourseService;
import Service.OpenCourseService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import java.util.List;

/**
 * Created by wangzhaojun on 2017/4/19.
 */
public class OpenCourseServiceImpl implements OpenCourseService {
    private OpenCourseDaoImpl openCourseDao;
    private Course_OpenCourse_DaoImpl course_openCourse_dao;

    public void setCourse_openCourse_dao(Course_OpenCourse_DaoImpl course_openCourse_dao) {
        this.course_openCourse_dao = course_openCourse_dao;
    }

    public void setOpenCourseDao(OpenCourseDaoImpl openCourseDao) {
        this.openCourseDao = openCourseDao;
    }


//    public List<T> find(String hql){
//        return (List<T>)getSessionFactory().getCurrentSession()
//                .createQuery(hql)
//                .list();
//    }


    //查询  详细的开课信息 （为了选课）
    @Transactional
    public List<Course_OpenCourse_cid> get_all_inf(){
        String hql="select new Entity.multiQuery.Course_OpenCourse_cid(x.cid,x.tid,x.time,x.semester,y.cname,y.ccredit) " +
                "from OpenCourse x,Course y " +
                "where x.cid=y.cid";
        return course_openCourse_dao.find(hql);
    }


    //多表查询问题
    //查询所有开课信息
    @Transactional
    public List<OpenCourse> get_all() {
        return openCourseDao.findall(OpenCourse.class);

    }
}

package Service.impl;

import Dao.impl.SelectCourseDaoImpl;
import Entity.SelectCourse;
import Entity.SelectCoursePK;
import Entity.multiQuery.sC_C_T;
import Service.SelectCourseService;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Table;
import javax.servlet.http.HttpSession;
import java.util.List;
import Dao.impl.sC_C_T_DaoImpl;
/**
 * Created by wangzhaojun on 2017/4/21.
 */
public class SelectCourseServiceImpl implements SelectCourseService {
    private SelectCourseDaoImpl selectCourseDao;

    private sC_C_T_DaoImpl sC_c_t_dao;

    public void setsC_c_t_dao(sC_C_T_DaoImpl sC_c_t_dao) {
        this.sC_c_t_dao = sC_c_t_dao;
    }

    public void setSelectCourseDao(SelectCourseDaoImpl selectCourseDao) {
        this.selectCourseDao = selectCourseDao;
    }

//    @Transactional
//    public SelectCoursePK save(SelectCourse selectCourse) {
//        return (SelectCoursePK) selectCourseDao.save(selectCourse);
//    }


    @Transactional
    public SelectCoursePK save(SelectCourse selectCourse) {
        return (SelectCoursePK) selectCourseDao.save(selectCourse);
    }

    public List<SelectCourse> get_all() {
        return null;
    }




    //查询当前已选的课程
    @Transactional
    public List<sC_C_T> get_all_inf() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String sid = (String)session.getAttribute("userID");
        System.out.println("当前学号"+sid);
        String hql = "select new Entity.multiQuery.sC_C_T(x.cid,y.cname,x.tid,z.time) " +
                "from SelectCourse x,Course y,OpenCourse z " +
                "where x.cid =y.cid and x.cid=z.cid and x.tid=z.tid " +
                "and x.sid = "+ sid;
        return sC_c_t_dao.find(hql);
    }


    // 根据复合主键类删除
    @Transactional
    public void deletedelete(SelectCoursePK selectCoursePK){
        SelectCourse selectCourse = selectCourseDao.get(SelectCourse.class,selectCoursePK);
        selectCourseDao.delete(selectCourse);
    }




    @Transactional
    public List<SelectCourse> get_all_ById() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        String sid = (String)session.getAttribute("userID");
        String hql = "from SelectCourse " +
                "where sid=?";
        return selectCourseDao.find_withOnePara(hql,sid);
    }

    @Transactional
    public SelectCourse get_selectCourse(SelectCoursePK selectCoursePK){
        return selectCourseDao.get(SelectCourse.class,selectCoursePK);
    }



    @Transactional
    public boolean timeConflict(String time,String id) {
// 这里有问题！要根据学号查询返回结果
        String hql = "from SelectCourse " +
                "where sid=?";
        List<SelectCourse> selectCourseList = selectCourseDao.find_withOnePara(hql,id);
        for (SelectCourse i:selectCourseList){
            System.out.println("时间"+i.getOpenCourseByOpenCoursePK().getTime());
            if (i.getOpenCourseByOpenCoursePK().getTime().equals(time))
                return false;
        }
        return true;
    }
}

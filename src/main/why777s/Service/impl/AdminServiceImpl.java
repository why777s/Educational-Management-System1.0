package Service.impl;

import Dao.impl.AdminDaoImpl;
import Entity.Admin;
import Service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;
import other.MD5;

import javax.servlet.http.HttpSession;

/**
 * Created by wangzhaojun on 2017/4/28.
 */
public class AdminServiceImpl implements AdminService {
    private AdminDaoImpl adminDao;

    public void setAdminDao(AdminDaoImpl adminDao) {
        this.adminDao = adminDao;
    }

    @Transactional
    public boolean login(Admin admin) {
        Admin ad = adminDao.get(Admin.class,admin.getAdminId());
        if (ad == null){
            System.out.println("工号为"+admin.getAdminId()+"的管理员不存在");
            return false;
        }else {
            System.out.println("该管理员工号为:"+ad.getAdminId());
            System.out.println("姓名为:"+ad.getAdminName());
//            return ad.getPassword().equals(admin.getPassword());
            try{
                String new_tstr = new MD5().getMD5(admin.getPassword());
                if (new_tstr.equals(ad.getPassword()))
                    return true;
            }catch (Exception e){
                e.printStackTrace();
            }
            return false;
        }
    }

    @Transactional
    public Admin getAdminInfo() {
        HttpSession session = ServletActionContext.getRequest().getSession();
        return adminDao.get(Admin.class,(String)session.getAttribute("userID"));
    }
}

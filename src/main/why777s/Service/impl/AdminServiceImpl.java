package Service.impl;

import Dao.impl.AdminDaoImpl;
import Entity.Admin;
import Service.AdminService;
import org.springframework.transaction.annotation.Transactional;

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
            return ad.getPassword().equals(admin.getPassword());
        }
    }
}

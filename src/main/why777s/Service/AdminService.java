package Service;

import Entity.Admin;

/**
 * Created by wangzhaojun on 2017/4/28.
 */
public interface AdminService {
    // 管理员登录
    boolean login(Admin admin);

    // 返回当前登录管理员个人信息
    Admin getAdminInfo();
}

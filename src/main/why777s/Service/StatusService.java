package Service;

import Entity.Status;

/**
 * Created by wangzhaojun on 2017/5/11.
 */
public interface StatusService {
//    关闭选课
    void change_to_zero();
//    开放选课
    void change_to_one();
//    获得当前是否开放选课的状态
    Status get_Status();
}

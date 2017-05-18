用户测试:
学生 id:0001 密码:0001
教师 id:T001 密码:T001
管理员 id:admin01 密码:admin01

package why777s.Controller

    FuncAction —— 专门处理功能类的Action

    loginAction —— 专门处理登录的Action

    NavigateAction —— 专门处理页面（局部）跳转的Action


package why777s.Entity
   （都是hibernate自动生成的）
    Admin —— 管理员映射类
    College —— 学院映射类
    Course  —— 课程映射类
    OpenCourse —— 开课表映射类
        OpenCoursePK    —— 开课表的复合主键类
    SelectCourse    —— 选课表映射类
        SelectCoursePK  —— 选课表的复合主键类
    Status  —— 系统状态表（管理员设置是否可以选课）
    Student —— 学生映射类
    Teacher —— 教师映射类


web端各页面说明：

index.jsp -- 登录的首页（选择学生or教师or管理员登录）

学生用户:
studentLogin.jsp —— 学生登录后的主界面
course_list.jsp —— 查看本学期开设的所有课程页面
selectCoursePage.jsp —— 学生选课页面
stu_schedule.jsp —— 学生课程表（学生已选课程 后续会丰富这一模块）
tuike.jsp —— 学生退课页面

教师用户:
teachetLogin.jsp —— 教师登录后的主界面
tea_schedule.jsp —— 教师课程表页面
gradeEntry.jsp —— 教师登分页面


管理员用户:
adminLogin.jsp —— 管理员登录后的主界面

only for Action Debugging:
loginError.jsp  —— result = "success"
loginSuc.jsp    —— result = "error"
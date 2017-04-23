package Entity;

import java.sql.Timestamp;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class Teacher {
    private String tid;
    private String tname;
    private String password;
    private String sex;
    private Timestamp birthdate;
    private String title;
    private Integer salary;
    private College collegeByYxh;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (tid != null ? !tid.equals(teacher.tid) : teacher.tid != null) return false;
        if (tname != null ? !tname.equals(teacher.tname) : teacher.tname != null) return false;
        if (password != null ? !password.equals(teacher.password) : teacher.password != null) return false;
        if (sex != null ? !sex.equals(teacher.sex) : teacher.sex != null) return false;
        if (birthdate != null ? !birthdate.equals(teacher.birthdate) : teacher.birthdate != null) return false;
        if (title != null ? !title.equals(teacher.title) : teacher.title != null) return false;
        if (salary != null ? !salary.equals(teacher.salary) : teacher.salary != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tid != null ? tid.hashCode() : 0;
        result = 31 * result + (tname != null ? tname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthdate != null ? birthdate.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        return result;
    }

    public College getCollegeByYxh() {
        return collegeByYxh;
    }

    public void setCollegeByYxh(College collegeByYxh) {
        this.collegeByYxh = collegeByYxh;
    }
}

package Entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by wangzhaojun on 2017/5/1.
 */
@Entity
@Table(name = "teacher")
public class Teacher {
    private String tid;
    private String tname;
    private String password;
    private String sex;
    private Timestamp birthdate;
    private String title;
    private Integer salary;
    private College collegeByYxh;

    @Id
    @Column(name = "tid", nullable = false, length = 8)
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "tname", nullable = false, length = 45)
    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 2)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthdate", nullable = true)
    public Timestamp getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Timestamp birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "salary", nullable = true)
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

    @ManyToOne
    @JoinColumn(name = "yxh", referencedColumnName = "yxh")
    public College getCollegeByYxh() {
        return collegeByYxh;
    }

    public void setCollegeByYxh(College collegeByYxh) {
        this.collegeByYxh = collegeByYxh;
    }
}

package Entity;

import javax.persistence.*;

/**
 * Created by wangzhaojun on 2017/5/1.
 */
@Entity
@Table(name = "student")
public class Student {
    private String sid;
    private String sname;
    private String password;
    private String sex;
    private String jiguan;
    private Integer scredit;
    private Integer tuition;
    private College collegeByYxh;

    @Basic
    @Column(name = "tuition" ,nullable = true )
    public Integer getTuition() {
        return tuition;
    }

    public void setTuition(Integer tuition) {
        this.tuition = tuition;
    }

    @Id
    @Column(name = "sid", nullable = false, length = 8)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Basic
    @Column(name = "sname", nullable = false, length = 45)
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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
    @Column(name = "jiguan", nullable = true, length = 45)
    public String getJiguan() {
        return jiguan;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }


    @Basic
    @Column(name = "scredit", nullable = true)
    public Integer getScredit() {
        return scredit;
    }

    public void setScredit(Integer scredit) {
        this.scredit = scredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (sid != null ? !sid.equals(student.sid) : student.sid != null) return false;
        if (sname != null ? !sname.equals(student.sname) : student.sname != null) return false;
        if (password != null ? !password.equals(student.password) : student.password != null) return false;
        if (sex != null ? !sex.equals(student.sex) : student.sex != null) return false;
        if (jiguan != null ? !jiguan.equals(student.jiguan) : student.jiguan != null) return false;
        if (scredit != null ? !scredit.equals(student.scredit) : student.scredit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (sname != null ? sname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (jiguan != null ? jiguan.hashCode() : 0);
        result = 31 * result + (scredit != null ? scredit.hashCode() : 0);
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

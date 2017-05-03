package Entity;

import javax.persistence.*;

/**
 * Created by wangzhaojun on 2017/5/1.
 */
@Entity
@Table(name = "course")
public class Course {
    private String cid;
    private String cname;
    private Integer ccredit;
    private College collegeByYxh;

    @Id
    @Column(name = "cid", nullable = false, length = 8)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "cname", nullable = false, length = 45)
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "ccredit", nullable = true)
    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (cid != null ? !cid.equals(course.cid) : course.cid != null) return false;
        if (cname != null ? !cname.equals(course.cname) : course.cname != null) return false;
        if (ccredit != null ? !ccredit.equals(course.ccredit) : course.ccredit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (cname != null ? cname.hashCode() : 0);
        result = 31 * result + (ccredit != null ? ccredit.hashCode() : 0);
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

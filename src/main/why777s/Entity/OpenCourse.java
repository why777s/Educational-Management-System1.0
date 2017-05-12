package Entity;

import javax.persistence.*;

/**
 * Created by wangzhaojun on 2017/5/1.
 */
@Table(name = "openCourse")
@Entity
@IdClass(OpenCoursePK.class)
public class OpenCourse {
    private String cid;
    private String tid;
    private String time;
    private String semester;

    private Course courseByCid;



    @Id
    @Column(name = "cid", nullable = false, length = 8)
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Id
    @Column(name = "tid", nullable = false, length = 8)
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Basic
    @Column(name = "time", nullable = true, length = 45)
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Id
    @Column(name = "semester", nullable = false, length = 45)
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OpenCourse that = (OpenCourse) o;

        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (semester != null ? !semester.equals(that.semester) : that.semester != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cid != null ? cid.hashCode() : 0;
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "cid", nullable = false,insertable = false,updatable = false)
    public Course getCourseByCid() {
        return courseByCid;
    }



    public void setCourseByCid(Course courseByCid) {
        this.courseByCid = courseByCid;
    }

}

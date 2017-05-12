package Entity;

import javax.persistence.*;

/**
 * Created by wangzhaojun on 2017/5/1.
 */

@Entity
@Table(name = "selectCourse")
@IdClass(SelectCoursePK.class)
public class SelectCourse {
    private String sid;
    private String semester;
    private String cid;
    private String tid;
    private String pscj;
    private String kscj;
    private String zpcj;
    private Course courseByCid;
    private Student studentBySid;

    private OpenCourse openCourseByOpenCoursePK;



    @Id
    @Column(name = "sid", nullable = false, length = 8)
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Id
    @Column(name = "semester", nullable = false, length = 45)
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

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
    @Column(name = "pscj", nullable = true)
    public String getPscj() {
        return pscj;
    }

    public void setPscj(String  pscj) {
        this.pscj = pscj;
    }

    @Basic
    @Column(name = "kscj", nullable = true, length = 45)
    public String getKscj() {
        return kscj;
    }

    public void setKscj(String kscj) {
        this.kscj = kscj;
    }

    @Basic
    @Column(name = "zpcj", nullable = true, length = 45)
    public String getZpcj() {
        return zpcj;
    }

    public void setZpcj(String zpcj) {
        this.zpcj = zpcj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectCourse that = (SelectCourse) o;

        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (semester != null ? !semester.equals(that.semester) : that.semester != null) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;
        if (pscj != null ? !pscj.equals(that.pscj) : that.pscj != null) return false;
        if (kscj != null ? !kscj.equals(that.kscj) : that.kscj != null) return false;
        if (zpcj != null ? !zpcj.equals(that.zpcj) : that.zpcj != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        result = 31 * result + (pscj != null ? pscj.hashCode() : 0);
        result = 31 * result + (kscj != null ? kscj.hashCode() : 0);
        result = 31 * result + (zpcj != null ? zpcj.hashCode() : 0);
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


    @ManyToOne
    @JoinColumns(
            {
                    @JoinColumn(name = "cid",referencedColumnName = "cid",insertable = false,updatable = false),
                    @JoinColumn(name = "tid",referencedColumnName = "tid",insertable = false,updatable = false),
                    @JoinColumn(name = "semester",referencedColumnName = "semester",insertable = false,updatable = false)
            }
    )
    public OpenCourse getOpenCourseByOpenCoursePK() {
        return openCourseByOpenCoursePK;
    }

    public void setOpenCourseByOpenCoursePK(OpenCourse openCourseByOpenCoursePK) {
        this.openCourseByOpenCoursePK = openCourseByOpenCoursePK;
    }

    @ManyToOne
    @JoinColumn(name = "sid", referencedColumnName = "sid", nullable = false,insertable = false,updatable = false)
    public Student getStudentBySid() {
        return studentBySid;
    }
    public void setStudentBySid(Student studentBySid) {
        this.studentBySid = studentBySid;
    }
}

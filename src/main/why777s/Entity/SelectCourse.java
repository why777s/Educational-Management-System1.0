package Entity;

import javax.persistence.Entity;
import javax.persistence.IdClass;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
//@IdClass(SelectCoursePK.class)
public class SelectCourse {
    private String sid;
    private String semester;
    private String cid;
    private String tid;
    private Integer pscj;
    private String kscj;
    private String zpcj;
    private Course courseByCid;

    public SelectCourse() {
    }

    private SelectCoursePK selectCoursePK;

    public SelectCoursePK getSelectCoursePK() {
        return selectCoursePK;
    }

    public void setSelectCoursePK(SelectCoursePK selectCoursePK) {
        this.selectCoursePK = selectCoursePK;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Integer getPscj() {
        return pscj;
    }

    public void setPscj(Integer pscj) {
        this.pscj = pscj;
    }

    public String getKscj() {
        return kscj;
    }

    public void setKscj(String kscj) {
        this.kscj = kscj;
    }

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

    public Course getCourseByCid() {
        return courseByCid;
    }

    public void setCourseByCid(Course courseByCid) {
        this.courseByCid = courseByCid;
    }
}

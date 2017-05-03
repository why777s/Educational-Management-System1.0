package Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by wangzhaojun on 2017/5/1.
 */
public class SelectCoursePK implements Serializable {
    private String sid;
    private String semester;
    private String cid;
    private String tid;

    public SelectCoursePK() {
    }

    @Column(name = "sid", nullable = false, length = 8)
    @Id
    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    @Column(name = "semester", nullable = false, length = 45)
    @Id
    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Column(name = "cid", nullable = false, length = 8)
    @Id
    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    @Column(name = "tid", nullable = false, length = 8)
    @Id
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SelectCoursePK that = (SelectCoursePK) o;

        if (sid != null ? !sid.equals(that.sid) : that.sid != null) return false;
        if (semester != null ? !semester.equals(that.semester) : that.semester != null) return false;
        if (cid != null ? !cid.equals(that.cid) : that.cid != null) return false;
        if (tid != null ? !tid.equals(that.tid) : that.tid != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sid != null ? sid.hashCode() : 0;
        result = 31 * result + (semester != null ? semester.hashCode() : 0);
        result = 31 * result + (cid != null ? cid.hashCode() : 0);
        result = 31 * result + (tid != null ? tid.hashCode() : 0);
        return result;
    }
}

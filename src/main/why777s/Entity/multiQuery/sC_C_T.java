package Entity.multiQuery;

/**
 * Created by wangzhaojun on 2017/4/23.
 */
public class sC_C_T {
    private String sid;
    private String semester;
    private String cid;
    private String tid;
    private String cname;
    private String time;

    public sC_C_T() {
    }

    public sC_C_T(String cid, String cname, String tid, String time) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}

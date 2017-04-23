package Entity.multiQuery;

import Entity.College;

/**
 * Created by wangzhaojun on 2017/4/21.
 */
public class Course_OpenCourse_cid {
    private String cid;
    private String tid;
    private String time;
    private String semester;
    private String cname;
    private Integer ccredit;
    private College collegeByYxh;

    public Course_OpenCourse_cid() {
    }

    public Course_OpenCourse_cid(String cid) {
        this.cid = cid;
    }

    public Course_OpenCourse_cid(String cid, String tid, String time, String semester, String cname, Integer ccredit) {
        this.cid = cid;
        this.tid = tid;
        this.time = time;
        this.semester = semester;
        this.cname = cname;
        this.ccredit = ccredit;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    public College getCollegeByYxh() {
        return collegeByYxh;
    }

    public void setCollegeByYxh(College collegeByYxh) {
        this.collegeByYxh = collegeByYxh;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course_OpenCourse_cid)) return false;

        Course_OpenCourse_cid that = (Course_OpenCourse_cid) o;

        if (getCid() != null ? !getCid().equals(that.getCid()) : that.getCid() != null) return false;
        if (getTid() != null ? !getTid().equals(that.getTid()) : that.getTid() != null) return false;
        if (getTime() != null ? !getTime().equals(that.getTime()) : that.getTime() != null) return false;
        if (getSemester() != null ? !getSemester().equals(that.getSemester()) : that.getSemester() != null)
            return false;
        if (getCname() != null ? !getCname().equals(that.getCname()) : that.getCname() != null) return false;
        if (getCcredit() != null ? !getCcredit().equals(that.getCcredit()) : that.getCcredit() != null) return false;
        return getCollegeByYxh() != null ? getCollegeByYxh().equals(that.getCollegeByYxh()) : that.getCollegeByYxh() == null;
    }

    @Override
    public int hashCode() {
        int result = getCid() != null ? getCid().hashCode() : 0;
        result = 31 * result + (getTid() != null ? getTid().hashCode() : 0);
        result = 31 * result + (getTime() != null ? getTime().hashCode() : 0);
        result = 31 * result + (getSemester() != null ? getSemester().hashCode() : 0);
        result = 31 * result + (getCname() != null ? getCname().hashCode() : 0);
        result = 31 * result + (getCcredit() != null ? getCcredit().hashCode() : 0);
        result = 31 * result + (getCollegeByYxh() != null ? getCollegeByYxh().hashCode() : 0);
        return result;
    }
}

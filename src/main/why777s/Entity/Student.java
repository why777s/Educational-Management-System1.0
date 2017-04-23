package Entity;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class Student {
    private String sid;
    private String sname;
    private String password;
    private String sex;
    private String jiguan;
    private Integer scredit;
    private College collegeByYxh;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public String getJiguan() {
        return jiguan;
    }

    public void setJiguan(String jiguan) {
        this.jiguan = jiguan;
    }

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

    public College getCollegeByYxh() {
        return collegeByYxh;
    }

    public void setCollegeByYxh(College collegeByYxh) {
        this.collegeByYxh = collegeByYxh;
    }
}

package Entity;

import javax.persistence.*;

/**
 * Created by wangzhaojun on 2017/5/1.
 */
@Entity
@Table(name = "college")
public class College {
    private String yxh;
    private String yname;
    private String tel;



    @Id
    @Column(name = "yxh", nullable = false, length = 2)
    public String getYxh() {
        return yxh;
    }

    public void setYxh(String yxh) {
        this.yxh = yxh;
    }

    @Basic
    @Column(name = "yname", nullable = false, length = 45)
    public String getYname() {
        return yname;
    }

    public void setYname(String yname) {
        this.yname = yname;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 8)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        College college = (College) o;

        if (yxh != null ? !yxh.equals(college.yxh) : college.yxh != null) return false;
        if (yname != null ? !yname.equals(college.yname) : college.yname != null) return false;
        if (tel != null ? !tel.equals(college.tel) : college.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = yxh != null ? yxh.hashCode() : 0;
        result = 31 * result + (yname != null ? yname.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        return result;
    }

}

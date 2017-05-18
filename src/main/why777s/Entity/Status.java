package Entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangzhaojun on 2017/5/11.
 */




@Entity
public class Status {
    private int permitSelect;
    private String state;

    @Basic
    @Column(name = "permit_select", nullable = false)
    public int getPermitSelect() {
        return permitSelect;
    }

    public void setPermitSelect(int permitSelect) {
        this.permitSelect = permitSelect;
    }

    @Id
    @Column(name = "state", nullable = false, length = 45)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (permitSelect != status.permitSelect) return false;
        if (state != null ? !state.equals(status.state) : status.state != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = permitSelect;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}

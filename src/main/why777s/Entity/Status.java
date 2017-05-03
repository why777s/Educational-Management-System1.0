package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by wangzhaojun on 2017/5/1.
 */
@Entity
public class Status {
    private byte permitSelect;

    @Id
    @Column(name = "permit_select", nullable = false)
    public byte getPermitSelect() {
        return permitSelect;
    }

    public void setPermitSelect(byte permitSelect) {
        this.permitSelect = permitSelect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status = (Status) o;

        if (permitSelect != status.permitSelect) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) permitSelect;
    }
}

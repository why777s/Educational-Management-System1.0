package Entity;

/**
 * Created by wangzhaojun on 2017/4/17.
 */
public class Status {
    private byte permitSelect;

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

package entity.goods.furniture;

import entity.good.Good;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "table")
public class Table {
    private List<Good> good;

    public Table() {
    }

    public Table(List<Good> good) {
        this.good = good;
    }

    @XmlElement(name = "good")
    public List<Good> getGood() {
        return good;
    }

    public void setGood(List<Good> good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "Table{" +
                "good=" + good +
                '}';
    }
}

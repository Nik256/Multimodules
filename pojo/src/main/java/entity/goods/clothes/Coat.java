package entity.goods.clothes;

import entity.good.Good;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "coat")
public class Coat {
    private List<Good> good;

    public Coat() {
    }

    public Coat(List<Good> good) {
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
        return "Coat{" +
                "good=" + good +
                '}';
    }
}

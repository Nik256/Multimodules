package entity.goods.food;

import entity.good.Good;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "candy")
public class Candy {
    private List<Good> good;

    public Candy() {
    }

    public Candy(List<Good> good) {
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
        return "Candy{" +
                "good=" + good +
                '}';
    }
}

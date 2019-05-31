package entity.goods.clothes;

import entity.good.Good;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tshirt")
public class Tshirt {
    private List<Good> good;

    public Tshirt() {
    }

    public Tshirt(List<Good> good) {
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
        return "Tshirt{" +
                "good=" + good +
                '}';
    }
}

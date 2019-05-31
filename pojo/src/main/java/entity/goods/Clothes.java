package entity.goods;

import entity.goods.clothes.Coat;
import entity.goods.clothes.Tshirt;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "clothes")
public class Clothes {
    private Coat coat;
    private Tshirt tshirt;

    public Clothes() {
    }

    public Clothes(Coat coat, Tshirt tshirt) {
        this.coat = coat;
        this.tshirt = tshirt;
    }

    @XmlElement(name = "good")
    public Coat getCoat() {
        return coat;
    }

    public void setCoat(Coat coat) {
        this.coat = coat;
    }

    @XmlElement(name = "tshirt")
    public Tshirt getTshirt() {
        return tshirt;
    }

    public void setTshirt(Tshirt tshirt) {
        this.tshirt = tshirt;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "coat=" + coat +
                ", tshirt=" + tshirt +
                '}';
    }
}

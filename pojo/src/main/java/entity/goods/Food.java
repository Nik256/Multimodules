package entity.goods;

import entity.goods.food.Cake;
import entity.goods.food.Candy;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "food")
public class Food {
    private Cake cake;
    private Candy candy;

    public Food() {
    }

    public Food(Cake cake, Candy candy) {
        this.cake = cake;
        this.candy = candy;
    }

    @XmlElement(name = "cake")
    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    @XmlElement(name = "candy")
    public Candy getCandy() {
        return candy;
    }

    public void setCandy(Candy candy) {
        this.candy = candy;
    }

    @Override
    public String toString() {
        return "Food{" +
                "cake=" + cake +
                ", candy=" + candy +
                '}';
    }
}

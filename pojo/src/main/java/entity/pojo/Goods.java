package entity.pojo;

import com.fasterxml.jackson.annotation.JsonRootName;
import entity.goods.Clothes;
import entity.goods.Food;
import entity.goods.Furniture;

import javax.xml.bind.annotation.XmlElement;

@JsonRootName(value = "goods")
public class Goods {
    private Food food;
    private Clothes clothes;
    private Furniture furniture;

    public Goods() {
    }

    public Goods(Food food, Clothes clothes, Furniture furniture) {
        this.food = food;
        this.clothes = clothes;
        this.furniture = furniture;
    }

    @XmlElement(name = "food")
    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    @XmlElement(name = "clothes")
    public Clothes getClothes() {
        return clothes;
    }

    public void setClothes(Clothes clothes) {
        this.clothes = clothes;
    }

    @XmlElement(name = "furniture")
    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "food=" + food +
                ", clothes=" + clothes +
                ", furniture=" + furniture +
                '}';
    }
}

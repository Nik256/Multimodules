package entity.goods;

import entity.goods.furniture.Table;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "furniture")
public class Furniture {
    private Table table;

    public Furniture() {
    }

    public Furniture(Table table) {
        this.table = table;
    }

    @XmlElement(name = "table")
    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "table=" + table +
                '}';
    }
}

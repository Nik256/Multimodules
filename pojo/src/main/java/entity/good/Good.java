package entity.good;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "good")
public class Good {
    @JacksonXmlProperty(isAttribute = true, localName = "id")
    private int id;
    private String manufacturer;
    private String model;
    private String date;
    private String color;
    private String amount;

    @XmlAttribute
    public int getId() {
        return id;
    }

    @XmlElement(name = "manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    @XmlElement(name = "model")
    public String getModel() {
        return model;
    }

    @XmlElement(name = "date")
    public String getDate() {
        return date;
    }

    @XmlElement(name = "color")
    public String getColor() {
        return color;
    }

    @XmlElement(name = "amount")
    public String getAmount() {
        return amount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", date='" + date + '\'' +
                ", color='" + color + '\'' +
                ", amount='" + amount + '\'' +
                '}';
    }
}

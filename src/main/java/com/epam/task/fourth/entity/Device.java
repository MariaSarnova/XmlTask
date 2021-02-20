package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.*;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
@XmlSeeAlso(Monitor.class)
public class Device {
    @XmlElement(namespace = "http://www.example.com/computers")
    private String name;
    @XmlElement(name = "devices-types", namespace = "http://www.example.com/computers")
    private DevicesTypes type;
    @XmlAttribute(required = true)
    @XmlID
    private String id;
    @XmlElement(namespace = "http://www.example.com/computers")
    private String origin;
    @XmlElement(namespace = "http://www.example.com/computers")
    private int price;


    public Device(){}

    public Device(String id, String name, String origin, int price, DevicesTypes type){
        this.id=id;
        this.name=name;
        this.origin=origin;
        this.price=price;
        this.type=type;
    }


    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public int getPrice() {
        return price;
    }

    public DevicesTypes getType() {
        return type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDevicesTypes(DevicesTypes type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Device device = (Device) o;
        return price == device.price &&
                Objects.equals(id, device.id) &&
                Objects.equals(name, device.name) &&
                Objects.equals(origin, device.origin) &&
                Objects.equals(type, device.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, origin, price, type);
    }

    @Override
    public String toString() {
        return "Devices{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}

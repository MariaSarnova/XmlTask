package com.epam.task.fourth.entity;

import java.util.Objects;

public abstract class Devices {
    private final int id;
    private String name;
    private String origin;
    private double price;
    private DevicesTypes type;
    private boolean critical;

    public Devices(int id,String name,String origin,double price,DevicesTypes type, boolean critical){
        this.id=id;
        this.name=name;
        this.origin=origin;
        this.price=price;
        this.type=type;
        this.critical=critical;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public double getPrice() {
        return price;
    }

    public DevicesTypes getType() {
        return type;
    }

    public boolean getCritical(){
        return critical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Devices devices = (Devices) o;
        return id == devices.id &&
                Double.compare(devices.price, price) == 0 &&
                critical == devices.critical &&
                Objects.equals(name, devices.name) &&
                Objects.equals(origin, devices.origin) &&
                Objects.equals(type, devices.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, origin, price, type, critical);
    }

    @Override
    public String toString() {
        return "Devices{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", critical=" + critical +
                '}';
    }
}

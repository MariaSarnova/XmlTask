package com.epam.task.fourth.entity;

import java.util.Objects;

public class Device {
    private final int id;
    private String name;
    private String origin;
    private int price;
    private DevicesTypes type;

    public Device(int id, String name, String origin, int price, DevicesTypes type){
        this.id=id;
        this.name=name;
        this.origin=origin;
        this.price=price;
        this.type=type;
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

    public int getPrice() {
        return price;
    }

    public DevicesTypes getType() {
        return type;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Device devices = (Device) o;
        return id == devices.id &&
                Double.compare(devices.price, price) == 0 &&
                Objects.equals(name, devices.name) &&
                Objects.equals(origin, devices.origin) &&
                Objects.equals(type, devices.type);
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

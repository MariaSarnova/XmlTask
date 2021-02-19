package com.epam.task.fourth.entity;

import java.util.Objects;

public class Monitor extends Devices{
    private double screenSize;

    public Monitor(int ID,String name,String origin,double price,DevicesTypes type, boolean critical,double screenSize){
        super(ID,name,origin,price,type,critical);
        this.screenSize=screenSize;
    }

    public double getScreenSize() {
        return screenSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Monitor monitor = (Monitor) o;
        return Double.compare(monitor.screenSize, screenSize) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), screenSize);
    }
}

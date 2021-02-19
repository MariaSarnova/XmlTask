package com.epam.task.fourth.entity;

import java.util.Objects;

public class Monitor extends Device {
    private int screenSize;

    public Monitor(int ID,String name,String origin,int price,DevicesTypes type,int screenSize){
        super(ID,name,origin,price,type);
        this.screenSize=screenSize;
    }

    public int getScreenSize() {
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

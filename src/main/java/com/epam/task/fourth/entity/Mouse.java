package com.epam.task.fourth.entity;

import java.util.Objects;

public class Mouse extends Devices{
    private int buttonNumbers;

    public Mouse(int ID,String name,String origin,double price,DevicesTypes type, boolean critical,int buttonNumbers){
        super(ID,name,origin,price,type,critical);
        this.buttonNumbers=buttonNumbers;
    }

    public int getButtonNumbers(){
        return buttonNumbers;
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
        Mouse mouse = (Mouse) o;
        return buttonNumbers == mouse.buttonNumbers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), buttonNumbers);
    }
}

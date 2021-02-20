package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class Monitor extends Device {
    @XmlAttribute
    protected boolean colored;

    public Monitor(){}

    public Monitor(String ID,String name,String origin,int price,DevicesTypes type,boolean colored){
        super(ID,name,origin,price,type);
        this.colored=colored;
    }

    public boolean getColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Monitor monitor = (Monitor) o;
        return colored == monitor.colored;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), colored);
    }
}

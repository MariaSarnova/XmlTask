package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Objects;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType
public class DevicesTypes {
    @XmlElement(name = "energy-consumption", namespace = "http://www.example.com/computers")
    private int energyConsumption;
    @XmlElement(name = "group-of-components", namespace = "http://www.example.com/computers")
    private String groupOfComponents;

    public DevicesTypes(){super();}

    public DevicesTypes(int energyConsumption,String groupOfComponents){
        this.energyConsumption=energyConsumption;
        this.groupOfComponents=groupOfComponents;
    }

    public int getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(int energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public void setGroupOfComponents(String groupOfComponents) {
        this.groupOfComponents = groupOfComponents;
    }

    public String getGroupOfComponents() {
        return groupOfComponents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DevicesTypes that = (DevicesTypes) o;
        return energyConsumption == that.energyConsumption &&
                Objects.equals(groupOfComponents, that.groupOfComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash( energyConsumption, groupOfComponents);
    }

    @Override
    public String toString() {
        return "DevicesTypes{" +
                "energyConsumption=" + energyConsumption +
                ", groupOfComponents='" + groupOfComponents + '\'' +
                '}';
    }
}

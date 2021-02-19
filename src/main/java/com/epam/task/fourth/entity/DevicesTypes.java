package com.epam.task.fourth.entity;

import java.util.Objects;

public class DevicesTypes {
    private int energyConsumption;
    private String groupOfComponents;

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
        return Double.compare(that.energyConsumption, energyConsumption) == 0 &&
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

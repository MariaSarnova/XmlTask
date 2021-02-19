package com.epam.task.fourth.entity;

import java.util.Objects;

public class DevicesTypes {
    private Peripherality peripherality;
    private double energyConsumption;
    private String groupOfComponents;

    public DevicesTypes(Peripherality peripherality,double energyConsumption,String groupOfComponents){
        this.peripherality=peripherality;
        this.energyConsumption=energyConsumption;
        this.groupOfComponents=groupOfComponents;
    }

    public Peripherality getPeripherality() {
        return peripherality;
    }

    public void setPeripherality(Peripherality peripherality) {
        this.peripherality = peripherality;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
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
                peripherality == that.peripherality &&
                Objects.equals(groupOfComponents, that.groupOfComponents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peripherality, energyConsumption, groupOfComponents);
    }

    @Override
    public String toString() {
        return "DevicesTypes{" +
                "peripherality=" + peripherality +
                ", energyConsumption=" + energyConsumption +
                ", groupOfComponents='" + groupOfComponents + '\'' +
                '}';
    }
}

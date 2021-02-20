package com.epam.task.fourth.entity;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace = "http://www.example.com/computers")
public class Computers {
        @XmlElements({
                @XmlElement(name = "device", type = Device.class, namespace = "http://www.example.com/computers"),
                @XmlElement(name = "monitor", type = Monitor.class, namespace = "http://www.example.com/computers")
        })
    private List<Device> devices = new ArrayList<>();

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public List<Device> getDevices() {
        return devices;
    }

    @Override
    public String toString() {
        return "Computers{" +
                "devices=" + devices +
                '}';
    }
}

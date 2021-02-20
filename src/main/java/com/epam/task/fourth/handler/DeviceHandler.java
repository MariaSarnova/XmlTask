package com.epam.task.fourth.handler;

import com.epam.task.fourth.entity.Device;
import com.epam.task.fourth.entity.DevicesTypes;
import com.epam.task.fourth.entity.Monitor;
import com.epam.task.fourth.parser.TagsConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeviceHandler extends DefaultHandler implements TagsConstants {
    private final static Logger LOGGER = LogManager.getLogger(DeviceHandler.class);
    private List<Device> devices = new ArrayList<>();
    private Device currentDevice = new Device();
    private String currentTag = null;

    private final List<String> INFO_TAGS = Arrays.asList(NAME, ORIGIN,PRICE,ENERGY_CONSUMPTION, GROUP_OF_COMPONENTS);

    public List<Device> getDevices() {
        return devices;
    }

    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if (DEVICE.equals(localName)){
            currentDevice = new Device();
            String temp = attributes.getValue(0);
            currentDevice.setId(temp);

        } else if (MONITOR.equals(localName)){
            Monitor monitor = new Monitor();

            String temp = attributes.getValue(0);
            monitor.setId(temp);

            int length = attributes.getLength();
            if (length == 2){
                temp = attributes.getValue(1);
                boolean colored = Boolean.parseBoolean(temp);
                monitor.setColored(colored);
            } else {
                monitor.setColored(false);
            }
            currentDevice = monitor;

        }
        if (INFO_TAGS.contains(localName)){
            currentTag = localName;
        }

    }

    public void endElement(String uri, String localName, String qName) {
        if (DEVICE.equals(localName) || MONITOR.equals(localName)){
            devices.add(currentDevice);
        }
    }

    public void characters(char[] ch, int start, int length) {
        String textInfo = new String(ch, start, length);
        DevicesTypes parameters = currentDevice.getType();

        if(currentTag != null){
            switch (currentTag) {
                case NAME:
                    currentDevice.setName(textInfo);
                    break;
                case ORIGIN:
                    currentDevice.setOrigin(textInfo);
                    break;
                case PRICE:
                    currentDevice.setPrice(Integer.parseInt(textInfo));
                    break;
                case ENERGY_CONSUMPTION:
                    parameters.setEnergyConsumption(Integer.parseInt(textInfo));

                    break;
                case GROUP_OF_COMPONENTS:
                    parameters.setGroupOfComponents(textInfo);

                default:
                    LOGGER.info("<" + textInfo + ">" + " no such tag");
            }
        }
        currentTag = null;
    }
}

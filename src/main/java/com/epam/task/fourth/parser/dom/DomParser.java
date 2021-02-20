package com.epam.task.fourth.parser.dom;

import com.epam.task.fourth.entity.Device;
import com.epam.task.fourth.entity.DevicesTypes;
import com.epam.task.fourth.entity.Monitor;
import com.epam.task.fourth.exception.XmlException;
import com.epam.task.fourth.parser.TagsConstants;
import com.epam.task.fourth.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser implements XmlParser, TagsConstants {
    private final static Logger LOGGER = LogManager.getLogger(DomParser.class);
    private List<Device> devices = new ArrayList<>();

    @Override
    public List<Device> parse(String xmlFile) throws XmlException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(xmlFile);
            Element root = document.getDocumentElement();
            NodeList devicesList = root.getElementsByTagName(DEVICE);
            addDevices(devicesList);
            NodeList monitorList = root.getElementsByTagName(MONITOR);
            addDevices(monitorList);

            LOGGER.info(xmlFile + "DomParser");
            return devices;
        } catch (SAXException | IOException | ParserConfigurationException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

    private void addDevices(NodeList devicesList){
        for (int i = 0; i < devicesList.getLength(); i++){
            Element deviceElement = (Element) devicesList.item(i);
            String tagName = deviceElement.getTagName();
            if (DEVICE.equals(tagName)){
                Device device = fillDevice(deviceElement);
                devices.add(device);
            } else if (MONITOR.equals(tagName)){
                Monitor monitor = (Monitor) fillDevice(deviceElement);
                devices.add(monitor);
            }
        }
    }

    private Device fillDevice(Element deviceElement) {
        Device device = new Device();
        DevicesTypes devicesTypes = new DevicesTypes();

        String tagName = deviceElement.getTagName();
        if (MONITOR.equals(tagName)){
            Monitor monitor = new Monitor();
            String colored = deviceElement.getAttribute(COLORED);
            boolean actualColored = Boolean.parseBoolean(colored);
            monitor.setColored(actualColored);
            device = monitor;
        }

        String id = deviceElement.getAttribute(ID);
        device.setId(id);

        String name = getTagText(deviceElement, NAME);
        device.setName(name);

        String origin = getTagText(deviceElement, ORIGIN);
        device.setOrigin(origin);

        int price = Integer.parseInt(getTagText(deviceElement, PRICE));
        device.setPrice(price);

        int energyCons = Integer.parseInt(getTagText(deviceElement, ENERGY_CONSUMPTION));
        devicesTypes.setEnergyConsumption(energyCons);

        String group = getTagText(deviceElement, GROUP_OF_COMPONENTS);
        devicesTypes.setGroupOfComponents(group);

        device.setDevicesTypes(devicesTypes);

        return device;
    }

    private String getTagText(Element deviceElement, String tagName) {
        NodeList nodeList =deviceElement.getElementsByTagName(tagName);
        Node node = nodeList.item(0);
        String text = node.getTextContent();
        return text;
    }
}

package com.epam.task.fourth.parser.sax;

import com.epam.task.fourth.entity.Device;
import com.epam.task.fourth.exception.XmlException;
import com.epam.task.fourth.handler.DeviceHandler;
import com.epam.task.fourth.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.List;

public class SaxParser implements XmlParser {
    private final static Logger LOGGER = LogManager.getLogger(SaxParser.class);

    @Override
    public List<Device> parse(String xmlFile) throws XmlException {
        List<Device> devices;
        try {
            DeviceHandler deviceHandler = new DeviceHandler();
            XMLReader reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(deviceHandler);
            reader.parse(xmlFile);
            devices = deviceHandler.getDevices();

            LOGGER.info(xmlFile + "SaxParser");
            return devices;
        } catch (SAXException | IOException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }

}

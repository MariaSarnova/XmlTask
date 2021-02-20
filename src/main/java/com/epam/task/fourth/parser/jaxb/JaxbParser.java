package com.epam.task.fourth.parser.jaxb;

import com.epam.task.fourth.entity.Computers;
import com.epam.task.fourth.entity.Device;
import com.epam.task.fourth.exception.XmlException;
import com.epam.task.fourth.parser.XmlParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.List;

public class JaxbParser implements XmlParser {
    private final static Logger LOGGER = LogManager.getLogger(JaxbParser.class);
    private String xsdFile;

    public void setXsdFile(String xsdFile) {
        this.xsdFile = xsdFile;
    }

    @Override
    public List<Device> parse(String xmlFile) throws XmlException {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Computers.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            File schemaLocation = new File(xsdFile);
            Schema schema = schemaFactory.newSchema(schemaLocation);
            unmarshaller.setSchema(schema);

            File xmlLocation = new File(xmlFile);
            Computers computers = (Computers) unmarshaller.unmarshal(xmlLocation);

            LOGGER.info(xmlFile + "JaxbParser");
            return computers.getDevices();
        } catch (JAXBException | SAXException e) {
            throw new XmlException(e.getMessage(), e);
        }
    }
}

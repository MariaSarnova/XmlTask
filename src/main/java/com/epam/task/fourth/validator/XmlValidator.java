package com.epam.task.fourth.validator;


import com.epam.task.fourth.exception.XmlException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    private static final Logger LOGGER= LogManager.getLogger(XmlValidator.class);
    private final String XSD_FILE;

    public XmlValidator(String xsdFile){
        this.XSD_FILE=xsdFile;
    }

    public boolean isValid(String xmlFile) throws XmlException{
        SchemaFactory factory=SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        File schemaLocation=new File(XSD_FILE);

        try{
            Schema schema=factory.newSchema(schemaLocation);
            Validator validator=schema.newValidator();
            Source source=new StreamSource(xmlFile);
            validator.validate(source);
            LOGGER.info(xmlFile+"is valid");
            return true;
        } catch (SAXException | IOException e) {
            throw new XmlException(e.getMessage(),e);
        }
    }
}

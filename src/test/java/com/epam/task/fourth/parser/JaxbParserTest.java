package com.epam.task.fourth.parser;

import com.epam.task.fourth.exception.XmlException;
import com.epam.task.fourth.parser.jaxb.JaxbParser;

public class JaxbParserTest extends AbstractXmlParserTest{
    private final String FILE_PATH = "src/main/resources/";
    private JaxbParser parser = new JaxbParser();

    @Override
    public void testParseShouldReturnParsedDevicesWhenValidXmlFileApplied() throws XmlException {
        parser.setXsdFile(FILE_PATH+"computers.xsd");
        setParser(parser);
        super.testParseShouldReturnParsedDevicesWhenValidXmlFileApplied();
    }

    @Override
    public void testParseShouldThrowExceptionWhenInvalidXmlFileApplied() throws XmlException {
        parser.setXsdFile(FILE_PATH+"gbGBH.xsd");
        setParser(parser);
        super.testParseShouldThrowExceptionWhenInvalidXmlFileApplied();
    }
}

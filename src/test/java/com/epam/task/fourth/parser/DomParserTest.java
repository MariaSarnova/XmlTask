package com.epam.task.fourth.parser;

import com.epam.task.fourth.exception.XmlException;
import com.epam.task.fourth.parser.dom.DomParser;

public class DomParserTest extends AbstractXmlParserTest{
    private DomParser parser = new DomParser();

    @Override
    public void testParseShouldReturnParsedDevicesWhenValidXmlFileApplied() throws XmlException {
        setParser(parser);
        super.testParseShouldReturnParsedDevicesWhenValidXmlFileApplied();
    }

    @Override
    public void testParseShouldThrowExceptionWhenInvalidXmlFileApplied() throws XmlException {
        setParser(parser);
        super.testParseShouldThrowExceptionWhenInvalidXmlFileApplied();
    }
}

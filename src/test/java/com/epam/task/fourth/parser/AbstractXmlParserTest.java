package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Device;
import com.epam.task.fourth.entity.DevicesTypes;
import com.epam.task.fourth.entity.Monitor;
import com.epam.task.fourth.exception.XmlException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractXmlParserTest {
    private XmlParser parser;
    private final String VALID_XML_FILE = "src/main/resources/computers.xml";
    private final String INVALID_XML_FILE = "src/main/resources/orange.xml";

    private final Device FIRST_DEVICE = new Device("d01","pc","USA",1000, new DevicesTypes(13000, "multimedia"));
    private final Device SECOND_DEVICE =new Device("d02","notebook","Russia",1000, new DevicesTypes(13000, "multimedia"));
    private final Device FIRST_MONITOR=  new Monitor("m01","display5000","Russia",800, new DevicesTypes(1000, "multimedia"), false);
    private final Device SECOND_MONITOR= new Monitor("m02","display20","Ukraine",500, new DevicesTypes(700, "multimedia"), false);


    public void setParser(XmlParser parser){
        this.parser = parser;
    }

    @Test
    public void testParseShouldReturnParsedDevicesWhenValidXmlFileApplied() throws XmlException {

        List<Device> actual = (parser.parse(VALID_XML_FILE));
        System.out.println(actual);
        Assert.assertEquals(FIRST_DEVICE, actual.get(0));
        Assert.assertEquals(SECOND_DEVICE, actual.get(1));
        Assert.assertEquals(FIRST_MONITOR, actual.get(2));
        Assert.assertEquals(SECOND_MONITOR, actual.get(3));
    }

    @Test(expected = XmlException.class)
    public void testParseShouldThrowExceptionWhenInvalidXmlFileApplied() throws XmlException{
        List<Device> actual=parser.parse(INVALID_XML_FILE);
    }
}

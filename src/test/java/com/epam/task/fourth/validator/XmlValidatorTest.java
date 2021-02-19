package com.epam.task.fourth.validator;

import com.epam.task.fourth.exception.XmlException;
import org.junit.Assert;
import org.junit.Test;

public class XmlValidatorTest {
    private final String FILE_PATH = "src/main/resources/";
    private XmlValidator validator = new XmlValidator(FILE_PATH+"computers.xsd");

    @Test
    public void testIsValidShouldReturnTrueWhenFileIsValid() throws XmlException {
        boolean actual = validator.isValid(FILE_PATH+"computers.xml");

        Assert.assertTrue(actual);
    }

    @Test(expected = XmlException.class)
    public void testIsValidShouldReturnFalseWhenFileIsInvalid() throws XmlException {
        boolean actual =validator.isValid(FILE_PATH+"hello.xml");
    }

}
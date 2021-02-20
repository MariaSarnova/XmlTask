package com.epam.task.fourth.parser;

import com.epam.task.fourth.entity.Device;
import com.epam.task.fourth.exception.XmlException;

import java.util.List;

public interface XmlParser {

    List<Device> parse(String xmlFile) throws XmlException;
}

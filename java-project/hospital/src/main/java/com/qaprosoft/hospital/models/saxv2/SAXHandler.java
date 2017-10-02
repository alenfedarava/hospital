package com.qaprosoft.hospital.models.saxv2;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.qaprosoft.hospital.models.support.Driver;

public class SAXHandler extends DefaultHandler {
	List<Driver> drList = new ArrayList<>();
	Driver dr = null;
	String content = null;
	Integer value = null;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {

		case "driver":
			dr = new Driver();
			dr.setId(attributes.getValue("id"));
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {

		case "driver":
			drList.add(dr);
			break;
		case "firstName":
			dr.setFirstName(content);
			break;
		case "lastName":
			dr.setLastName(content);
			break;
		case "jobTitle":
			dr.setJobTitle(content);
			break;
		case "age":
			dr.setAge(value);
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}

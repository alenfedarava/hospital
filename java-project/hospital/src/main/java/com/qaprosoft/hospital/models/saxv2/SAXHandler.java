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
//	int value = null;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {

		case "employee":
			dr = new Driver();
			dr.setId(attributes.getValue("id"));
			break;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		// Add the employee to list once end tag is found
		case "employee":
			drList.add(dr);
			break;
		// For all other end tags the employee has to be updated.
		case "firstName":
			dr.firstName = content;
			break;
		case "lastName":
			dr.lastName = content;
			break;
//		case "age":
//			dr.setAge(content);
//			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
	}

}

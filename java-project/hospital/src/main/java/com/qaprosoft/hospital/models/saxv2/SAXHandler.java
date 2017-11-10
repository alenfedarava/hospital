package com.qaprosoft.hospital.models.saxv2;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.qaprosoft.hospital.models.Address;
import com.qaprosoft.hospital.models.Cities;
import com.qaprosoft.hospital.models.support.Driver;

public class SAXHandler extends DefaultHandler {
	List<Driver> drList = new ArrayList<>();
	Driver dr = null;
	Address a = null;
	String content = null;
	Integer value = null;
	Object object = null;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		switch (qName) {

		case "driver":
			dr = new Driver();
			dr.setId(attributes.getValue("id"));
			break;
		case "address":
			a = new Address();
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
			dr.setAge(Integer.valueOf(content));
			break;
		case "drivingExp":
			dr.setDrivingExp(Integer.valueOf(content));
			break;
		case "street":
			a.setStreet(content);
			break;
		case "houseNumber":
			a.setHouseNumber(Integer.valueOf(content));
			break;
		case "phone":
			a.setPhone(content);
			break;	
		case "cities":
			a.setCities(Cities.valueOf(content));
			break;	
		case "address":
			dr.setAddress(a);
		case "dateBirth":
			dr.setDateBirth(content);
		break;
			
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		content = String.copyValueOf(ch, start, length).trim();
		
	}

}

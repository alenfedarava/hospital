package com.qaprosoft.hospital.models.saxv2;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.qaprosoft.hospital.models.support.Driver;

public class SAXParserDemo {

	public static void main(String[] args) throws Exception {
		SAXParserFactory parserFactor = SAXParserFactory.newInstance();
		SAXParser parser = parserFactor.newSAXParser();
		SAXHandler handler = new SAXHandler();
		parser.parse(ClassLoader.getSystemClassLoader().getSystemResourceAsStream("newxml.xml"), handler);
		for (Driver dr : handler.drList) {
			System.out.println(dr);
		}
	}
}

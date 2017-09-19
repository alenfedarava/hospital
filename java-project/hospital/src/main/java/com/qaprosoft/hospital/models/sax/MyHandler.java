package com.qaprosoft.hospital.models.sax;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.qaprosoft.hospital.models.support.Driver;

public class MyHandler extends DefaultHandler {
	private static final Logger LOGGER = Logger.getLogger(MyHandler.class);

	private static final String HOSPITAL_TAG = "hospital";
	private static final String DRIVERS_TAG = "drivers";
	private static final String DRIVER_TAG = "driver";
	private static final String JANITORS_TAG = "janitors";
	private static final String JANITOR_TAG = "janitor";
	
	
}

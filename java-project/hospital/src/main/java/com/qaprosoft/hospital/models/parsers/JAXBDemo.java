package com.qaprosoft.hospital.models.parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JAXBDemo {
	
	public static void main(String[] args) {
		
		final Logger lOGGER = LogManager.getLogger(JAXBDemo.class);
		try {
			JAXBContext context = JAXBContext.newInstance(HospitalJAXB.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			FileReader reader = new FileReader("/Users/alenafedarava/hospital/java-project/hospital/src/main/resources/xml.xml");
			HospitalJAXB jaxbBuilder = (HospitalJAXB) unmarshaller.unmarshal(reader);
			lOGGER.info(jaxbBuilder.getDriversList().get(0).toString());
			lOGGER.info(jaxbBuilder.getDriversList().get(1).toString());
		} catch (JAXBException e) {
			lOGGER.error(e);
		} catch (FileNotFoundException e) {
			lOGGER.error(e);
		}

	}

}

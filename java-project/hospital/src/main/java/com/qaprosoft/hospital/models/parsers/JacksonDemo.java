package com.qaprosoft.hospital.models.parsers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;

public class JacksonDemo {

	public static void main(String[] args) {
		final Logger lOGGER = LogManager.getLogger(JacksonDemo.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			File reader = new File("/Users/alenafedarava/hospital/java-project/hospital/src/main/resources/json.json");
			mapper.setDateFormat(new SimpleDateFormat("dd.MM.yyyy"));
			HospitalJackson jacksonBuilder = mapper.readValue(reader, HospitalJackson.class);
			lOGGER.info(jacksonBuilder.getDrivers().get(0).toString());
			lOGGER.info(jacksonBuilder.getDrivers().get(1).toString());
		} catch (JsonGenerationException e) {
			lOGGER.info(e.getMessage());
		} catch (JsonMappingException e) {
			lOGGER.info(e.getMessage());
		} catch (IOException e) {
			lOGGER.info(e.getMessage());

		}

	}

}

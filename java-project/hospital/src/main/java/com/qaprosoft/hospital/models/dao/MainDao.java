package com.qaprosoft.hospital.models.dao;

import org.apache.log4j.Logger;

import com.qaprosoft.hospital.models.Address;
import com.qaprosoft.hospital.models.Cities;
import com.qaprosoft.hospital.models.dao.services.DriverService;
import com.qaprosoft.hospital.models.support.Driver;

public class MainDao {
	public static final Logger LOGGER = Logger.getLogger(MainDao.class);
	
	public static void main(String[] args) {
//		 DriverService driverService = new DriverService();

	        DriverService driverService = new DriverService();
	        Address address = new Address();
	        address.setCities(Cities.BORISOV);
	        address.setHouseNumber(1);
	        address.setId(1);
	        address.setPhone("+375298916677");
	        address.setStreet("Lenina");
	        
	        Driver driver = new Driver();
	        driver.setAddress(address);
	        driver.setAge(50);
	        driver.setDateBirth("12/12/1980");
	        driver.setDrivingExp(10);
	        driver.setFirstName("Petya");
	        driver.setId(1);
	        driver.setJobTitle("Driver");
	        driver.setLastName("Petrov");
	        driver.setPrivileges(false);
	        driver.setRelatedEducation(true);
	        
	        driverService.insert(driver);
//	        driverService.getById(1);
//	        driverService.delete(driver);
	        

	        System.out.println(driver);

	}

}

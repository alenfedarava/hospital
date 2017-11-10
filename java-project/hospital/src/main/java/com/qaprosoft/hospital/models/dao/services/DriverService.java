package com.qaprosoft.hospital.models.dao.services;

import java.util.List;

import com.qaprosoft.hospital.models.Address;
import com.qaprosoft.hospital.models.dao.IDao;
import com.qaprosoft.hospital.models.dao.impl.JDBCAddressDao;
import com.qaprosoft.hospital.models.dao.impl.JDBCDriverDao;
import com.qaprosoft.hospital.models.support.Driver;

public class DriverService {
	 private IDao<Driver> driverDao = new JDBCDriverDao();
	 private IDao<Address> addressDao = new JDBCAddressDao();
	 
	 public void insert (Driver driver) {
		 addressDao.insert(driver.getAddress());
		 driverDao.insert(driver);
	 }
	 
	 public Driver getById(long id) {
		 Driver driver = driverDao.getById(id);
		 driver.setAddress(addressDao.getById(id));
		 return driver;
	 }
	 
	 public List<Driver> getAll() {
		 addressDao.getAll();
		 driverDao.getAll();
		 return driverDao.getAll();
	 }
	 
	 public void update(Driver driver, Address address) {
		 addressDao.update(address);
		 driverDao.update(driver);
	 }
	 
	 public void delete (Driver driver) {
		 addressDao.delete(driver.getAddress());
		 driverDao.delete(driver);
	 }
}

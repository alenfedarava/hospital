package com.qaprosoft.hospital.models.dao;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.qaprosoft.hospital.models.dao.mybatis.MyBatisDriverDAO;
import com.qaprosoft.hospital.models.support.Driver;

public class MainMyBatis {
	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(MainMyBatis.class);
	public static void main(String[] args) {

        Driver driver = new Driver();
        MyBatisDriverDAO myBatisDriverDAO = new MyBatisDriverDAO();
        myBatisDriverDAO.getAll().forEach(LOGGER::info);
//        System.out.println(driver.getFirstName() + " " + driver.getLastName());

	}

}

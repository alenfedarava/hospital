package com.qaprosoft.hospital.models.dao;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import java.text.ParseException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.qaprosoft.hospital.models.connectionpool.ConnectionPool;

public abstract class AbstractDao {

	protected static final Logger LOGGER = Logger.getLogger(AbstractDao.class);

	public static SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

	private static Properties properties;
	private static InputStream inputStream;
	private ConnectionPool connectionPool = ConnectionPool.getInstance();

	protected void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
	}

	static {
		properties = new Properties();
		try {
			inputStream = new FileInputStream(
					"/Users/alenafedarava/hospital/java-project/hospital/src/main/resources/env.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				LOGGER.error(e);
			}
		}
	}

	private static String getConfig(String key) {
		return properties.getProperty(key);
	}

	public Connection getConnection() throws SQLException, InterruptedException {
		return connectionPool.getConnection(getConfig("url"), getConfig("username"), getConfig("password"));
	}

	public void closeConnection(Connection connection) {
		connectionPool.close(connection);
	}

	protected String convertFromSQLDateToJAVADate(java.sql.Date sqlDate) {
		String date = null;
		;
		if (sqlDate != null) {
			java.util.Date javaDate = new Date(sqlDate.getTime());
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.format(javaDate);
		}
		return date;
	}

	protected java.sql.Date convertFromJAVADateToSQLDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MMMM/yyyy");
		java.util.Date javaDate = null;
		try {
			javaDate = formatFromStringToDate(date, formatter);
		} catch (Exception e) {

			e.printStackTrace();
		}
		java.sql.Date sqlDate = null;
		if (javaDate != null)
			sqlDate = new java.sql.Date(javaDate.getTime());
		return sqlDate;
	}

	protected Date formatFromStringToDate(String string, SimpleDateFormat formatter) throws Exception {

		Date date = null;
		try {
			date = formatter.parse(string);
		} catch (ParseException e) {
			LOGGER.info(e.getMessage());
		}
		return date;
	}

}

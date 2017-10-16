package com.qaprosoft.hospital.models.JDBC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCConnectionToSQL {
	private static final Logger LOGGER = LogManager.getLogger(JDBCConnectionToSQL.class);

	protected static void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
	}

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Properties props = new Properties();
		String url = props.getProperty("jdbc.url");
		String user = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");
		FileInputStream env = null;

		Driver driver;

		try {
			driver = new com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(driver);
		} catch (SQLException e1) {
			System.out.println("Driver has not been registered!");
		}
		try {
			env = new FileInputStream("/Users/alenafedarava/hospital/java-project/hospital/src/main/resources/env.properties");
		} catch (FileNotFoundException e2) {
			LOGGER.error(e2.getMessage());
		}
		try {
			props.load(env);
		} catch (IOException e2) {
			LOGGER.error(e2.getMessage());
		} finally {
			close(env);
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
			if (!connection.isClosed())
				System.out.println("Connection has been established");
//		}catch (SQLException ex){
//				System.err.println("Connection hasn't been established");
//				ex.printStackTrace(); 
			preparedStatement = connection.prepareStatement("SELECT * FROM employees where id > ? and id < ?");
			preparedStatement.setInt(1, 5);
			preparedStatement.setInt(2, 10);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				LOGGER.info("" + resultSet.getRow() + "\t Employees_id " + resultSet.getInt("id") + "\t"
						+ resultSet.getString("firstname") + " " + resultSet.getString("lastname"));
			}

		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		} finally {
			close(connection);
			close(preparedStatement);
			close(resultSet);
		}
		
	}
	
	
}

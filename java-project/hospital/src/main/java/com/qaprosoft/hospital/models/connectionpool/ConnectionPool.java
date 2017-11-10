package com.qaprosoft.hospital.models.connectionpool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ConnectionPool {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(ConnectionPool.class);
	private static int poolsize = 4;
	private final static ConnectionPool instance = new ConnectionPool();
	private int connectionCounter;
	private String url;
	private String user;
	private String password;
	private Properties props;
	private Connection connection = null;

	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(poolsize);

	private ConnectionPool(int poolsize) {

	}

	public static ConnectionPool getInstance() {
		return instance;
	}

	private ConnectionPool() {
		props = new Properties();
		FileInputStream env = null;
		try {
			env = new FileInputStream(
					"/Users/alenafedarava/hospital/java-project/hospital/src/main/resources/env.properties");
			try {
				props.load(env);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e2) {
			LOGGER.error(e2.getMessage());
		} finally {
			close(env);
		}
		url = props.getProperty("jdbc.url");
		user = props.getProperty("jdbc.username");
		password = props.getProperty("jdbc.password");
	}

//	private Connection getConnection() throws Exception {
//		if (pool.isEmpty() && connection.availableConn < poolsize) {
//			pool.add(new Connection());
//			LOGGER.info("Connection has been created!");
//			pool.take();
//			LOGGER.info("Connection has been locked!");
//		} else if (pool.size() > 0)
//			;
//		return pool.take();
//	}
	private Connection initiateConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			LOGGER.error(e.getMessage());
		}
		return connection;
	}

	public Connection getConnection(String url, String username, String password) throws InterruptedException {
		if (pool.isEmpty() && (connectionCounter < poolsize)) {
			pool.add(initiateConnection());
			connectionCounter++;
		}
		return pool.take();
	}

	private void releaseConnection(Connection connection) {
		if (connection != null && pool.size() < poolsize)
			pool.add(connection);
		LOGGER.info("Connection has been returned!");
	}

	private void closeConnection(Connection connection) throws SQLException {
		connection.close();
	}

	public void close(AutoCloseable resourse) {
		if (resourse != null)
			try {
				resourse.close();
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
	}
}

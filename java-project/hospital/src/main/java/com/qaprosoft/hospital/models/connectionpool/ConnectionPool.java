package com.qaprosoft.hospital.models.connectionpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class ConnectionPool {
	private static final Logger LOGGER = (Logger) LogManager.getLogger(ConnectionPool.class);
	private static int poolsize = 4;
	private final static ConnectionPool instance = new ConnectionPool(poolsize);

	private BlockingQueue<Connection> pool = new ArrayBlockingQueue<>(poolsize);

	private ConnectionPool(int poolsize) {

	}

	public static ConnectionPool getInstance() {
		return instance;
	}

	private Connection getConnection() throws Exception {
		if (pool.isEmpty() && Connection.availableConn < poolsize) {
			pool.add(new Connection());
			LOGGER.info("Connection has been created!");
			pool.take();
			LOGGER.info("Connection has been locked!");
		} else if (pool.size() > 0)
			;
		return pool.take();
	}

	private void releaseConnection(Connection connection) {
		if (connection != null && pool.size() < poolsize)
			pool.add(connection);
		LOGGER.info("Connection has been returned!");
	}

	private void closeConnection(Connection connection) {
		connection.close();
	}
}

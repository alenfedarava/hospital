package com.qaprosoft.hospital.models.DAO;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.hospital.models.connectionpool.Connection;
import com.qaprosoft.hospital.models.connectionpool.ConnectionPool;

public abstract class AbstractController<E, K> {
	private static final Logger LOGGER = LogManager.getLogger(AbstractController.class);
	private Connection connection;
	private ConnectionPool connectionPool;

	public AbstractController() {
	}

	public abstract List<E> getAll();

	public abstract E getEntityById(K id);

	public abstract E update(E entity);

	public abstract boolean delete(K id);

	public abstract boolean create(E entity);

}

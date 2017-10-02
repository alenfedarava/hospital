package com.qaprosoft.hospital.models.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.qaprosoft.hospital.models.connectionpool.Connection;
import com.qaprosoft.hospital.models.connectionpool.ConnectionPool;

public abstract class AbstractController<E, K> {

	private Connection connection;
	private ConnectionPool connectionPool;

	public AbstractController() {
		connectionPool = ConnectionPool.getConnection();
		connection = connectionPool.getConnection();
	}

	public abstract List<E> getAll();

	public abstract E getEntityById(K id);

	public abstract E update(E entity);

	public abstract boolean delete(K id);

	public abstract boolean create(E entity);

	public PreparedStatement getPrepareStatement(String sql) {
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ps;
	}

	public void closePrepareStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

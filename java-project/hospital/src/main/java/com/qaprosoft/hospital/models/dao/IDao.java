package com.qaprosoft.hospital.models.dao;

import java.util.List;

public interface IDao<T> {

	void insert(T entity);

	T getById(int id);

	void update(T entity);

	void delete(T entity);

	List<T> getAll();
}

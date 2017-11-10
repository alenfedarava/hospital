package com.qaprosoft.hospital.models.dao;

import java.util.List;

import com.qaprosoft.hospital.models.AbstractEntity;

public interface IDao<T extends AbstractEntity> {
 
	void insert(T entity);

	T getById(long id);

	void update(T entity);

	void delete(T entity);

	List<T> getAll();
}

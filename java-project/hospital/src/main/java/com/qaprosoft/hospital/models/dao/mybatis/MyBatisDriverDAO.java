package com.qaprosoft.hospital.models.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.qaprosoft.hospital.models.dao.AbstractDao;
import com.qaprosoft.hospital.models.dao.IDriverDao;
import com.qaprosoft.hospital.models.support.Driver;

public class MyBatisDriverDAO extends AbstractDao implements IDriverDao {

	@Override
	public void insert(Driver driver) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.insert("com.qaprosoft.hospital.models.dao.mybatis.MyBatisDriverDao.insert", driver);
			session.commit();
		} finally {
			close(session);
		}

	}

	@Override
	public Driver getById(long id) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectOne("com.qaprosoft.hospital.models.dao.mybatis.MyBatisDriverDao.getById", id);
		} finally {
			close(session);
		}

	}

	@Override
	public void update(Driver driver) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.update("com.qaprosoft.hospital.models.dao.mybatis.MyBatisDriverDao.update", driver);
			session.commit();
		} finally {
			close(session);
		}

	}

	@Override
	public void delete(Driver driver) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.delete("com.qaprosoft.hospital.models.dao.mybatis.MyBatisDriverDao.delete", driver);
			session.commit();
		} finally {
			close(session);
		}

	}

	@Override
	public List<Driver> getAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("com.qaprosoft.hospital.models.dao.mybatis.MyBatisDriverDao.getAll");
		} finally {
			close(session);
		}

	}

}

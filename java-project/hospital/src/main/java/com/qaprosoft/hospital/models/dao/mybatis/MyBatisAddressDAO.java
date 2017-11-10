package com.qaprosoft.hospital.models.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.qaprosoft.hospital.models.Address;
import com.qaprosoft.hospital.models.dao.AbstractDao;
import com.qaprosoft.hospital.models.dao.IAddressDao;

public class MyBatisAddressDAO extends AbstractDao implements IAddressDao {

	@Override
	public void insert(Address address) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.insert("com.qaprosoft.hospital.models.dao.mybatis.MyBatisAddressDAO.insert", address);
			session.commit();
		} finally {
			close(session);
		}

	}

	@Override
	public Address getById(long id) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectOne("com.qaprosoft.hospital.models.dao.mybatis.MyBatisAddressDAO.getById", id);
		} finally {
			close(session);
		}

	}

	@Override
	public void update(Address address) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.update("com.qaprosoft.hospital.models.dao.mybatis.MyBatisAddressDAO.update", address);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public void delete(Address address) {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			session.delete("com.qaprosoft.hospital.models.dao.mybatis.MyBatisAddressDAO.delete", address);
			session.commit();
		} finally {
			close(session);
		}
	}

	@Override
	public List<Address> getAll() {
		SqlSession session = null;
		try {
			session = getSqlSessionFactory().openSession();
			return session.selectList("com.qaprosoft.hospital.models.dao.mybatis.MyBatisAddressDAO.getAll");
		} finally {
			close(session);
		}

	}

}

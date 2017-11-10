package com.qaprosoft.hospital.models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.hospital.models.dao.AbstractDao;
import com.qaprosoft.hospital.models.dao.IDao;
import com.qaprosoft.hospital.models.support.Driver;

public class JDBCDriverDao extends AbstractDao implements IDao<Driver> {
	private static final Logger LOGGER = LogManager.getLogger(JDBCDriverDao.class);

	@Override
	public void insert(Driver driver) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT INTO Driver (FIRST_NAME, LAST_NAME, AGE, JOB_TITLE, DATE_BIRTH, RELATED_EDUCATION, PRIVILEGE, DRIVING_EXP) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			preparedStatement.setString(1, driver.getFirstName());
			preparedStatement.setString(2, driver.getLastName());
			preparedStatement.setInt(3, driver.getAge());
//			preparedStatement.setDate(4, convertFromJAVADateToSQLDate(driver.getDateBirth()));
			preparedStatement.setString(4, String.valueOf(driver.getDateBirth()));
			preparedStatement.setString(5, driver.getJobTitle());
			preparedStatement.setBoolean(6, driver.isRelatedEducation());
			preparedStatement.setBoolean(7, driver.isPrivileges());
			preparedStatement.setInt(8, driver.getDrivingExp());

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			closeConnection(connection);
		}

	}

	@Override
	public Driver getById(long id) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Driver driver = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(
					"SELECT D.ID, D.FIRST_NAME, D.LAST_NAME, D.AGE, D.JOB_TITLE, D.DATE_BIRTH, D.RELATED_EDUCATION, D.PRIVILEGE, D.DRIVING_EXP FROM DRIVER A WHERE D.ID = ?");
			preparedStatement.setLong(1, id);

			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {

				driver = new Driver();
				driver.setId(resultSet.getLong("ID"));
				driver.setFirstName(resultSet.getString("FIRST_NAME"));
				driver.setLastName(resultSet.getString("LAST_NAME"));
				driver.setAge(resultSet.getInt("AGE"));
//				driver.setDateBirth(resultSet.getDate("DATE_BIRTH"));
				driver.setJobTitle(resultSet.getString("JOB_TITLE"));
				driver.setPrivileges(resultSet.getBoolean("PRIVILEGE"));
				driver.setRelatedEducation(resultSet.getBoolean("RELATED_EDUCATION"));
				driver.setDrivingExp(resultSet.getInt("DRIVING_EXP"));

			}

		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			closeConnection(connection);
		}
		return driver;
	}

	@Override
	public void update(Driver driver) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(
					"UPDATE Driver SET FIRST_NAME = ?, LAST_NAME = ?, AGE = ?, DATE_BIRTH = ?, JOB_TITLE = ?, PRIVILEGE = ?, RELATED_EDUCATION = ?, DRIVING_EXP = ? WHERE ID = ?");
			preparedStatement.setString(1, driver.getFirstName());
			preparedStatement.setString(2, driver.getLastName());
			preparedStatement.setInt(3, driver.getAge());
			preparedStatement.setString(4, String.valueOf(driver.getDateBirth()));
			preparedStatement.setString(5, driver.getJobTitle());
			preparedStatement.setBoolean(6, driver.isPrivileges());
			preparedStatement.setBoolean(7, driver.isRelatedEducation());
			preparedStatement.setInt(8, driver.getDrivingExp());
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				LOGGER.error(e);
			}
			closeConnection(connection);
		}

	}

	@Override
	public void delete(Driver driver) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM Driver WHERE ID = ?");
            preparedStatement.setLong(1, driver.getId());
            preparedStatement.execute();
        } catch (Exception e) {

            LOGGER.error(e.getMessage());
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }

	}

	@Override
	public List<Driver> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Driver driver = null;
        List<Driver> drivers = new ArrayList<>();
        ResultSet resultSet = null;
        
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM Driver");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                driver = new Driver();
                driver.setId(resultSet.getLong("ID"));
                driver.setFirstName(resultSet.getString("FIRST_NAME"));
                driver.setLastName(resultSet.getString("LAST_NAME"));
                driver.setAge(resultSet.getInt("Age"));
                driver.setDateBirth(convertFromSQLDateToJAVADate(resultSet.getDate("D.DATE_OF_BIRTH")));
                driver.setJobTitle(resultSet.getString("JOB_TITLE"));
                driver.setPrivileges(resultSet.getBoolean("PRIVILEGES"));
                driver.setRelatedEducation(resultSet.getBoolean("RELATED_EDUCATION"));
                driver.setDrivingExp(resultSet.getInt("DRIVING_EXP"));
                
                drivers.add(driver);
            }

        } catch (Exception e) {
            LOGGER.error(e);
        }finally {
            try {
                preparedStatement.close();
                resultSet.close();
            } catch (SQLException e) {
                LOGGER.error(e);
            }
            closeConnection(connection);
        }
        
		return drivers;
	}

}

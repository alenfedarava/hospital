package com.qaprosoft.hospital.models.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.hospital.models.Address;
import com.qaprosoft.hospital.models.Cities;
import com.qaprosoft.hospital.models.dao.AbstractDao;
import com.qaprosoft.hospital.models.dao.IDao;

public class JDBCAddressDao extends AbstractDao implements IDao<Address> {
	private static final Logger LOGGER = LogManager.getLogger(JDBCAddressDao.class);

	@Override
	public void insert(Address address) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(
					"INSERT INTO address (PHONE, STREET, CITIES, HOUSE_NUMBER) VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, address.getPhone());
			preparedStatement.setString(2, address.getStreet());
			preparedStatement.setObject(3, address.getCities());
			preparedStatement.setInt(4, address.getHouseNumber());

			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				address.setId(resultSet.getLong(1));
			}
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				LOGGER.info(e);
			}
			closeConnection(connection);
		}

	}

	@Override
	public Address getById(long id) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Address address = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT A.ID, A.PHONE, A.CITIES, A.STREET, A.HOUSE_NUMBER FROM Address A WHERE A.ID = ?");
            preparedStatement.setLong(1, id);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {

                address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCities(Cities.valueOf(resultSet.getString("CITIES")));
                address.setPhone(resultSet.getString("PHONE"));
                address.setStreet(resultSet.getString("STREET"));
                address.setHouseNumber(resultSet.getInt("HOUSE_NUMBER")); 
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
		return address;
	}


	@Override
	public void update(Address address) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("UPDATE address SET CITIES = ?, PHONE = ?, STREET = ?, HOUSE_NUMBER = ? WHERE ID = ?");
//            preparedStatement.setString(1, Cities.valueOf(resultSet.getString("CITIES")));
            preparedStatement.setString(2, address.getPhone());
            preparedStatement.setString(3, address.getStreet());
            preparedStatement.setInt(4, address.getHouseNumber());
            preparedStatement.setLong(5, address.getId());

            preparedStatement.executeUpdate();
        } catch (Exception e) {
            LOGGER.error(e);
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
	public void delete(Address address) {
		Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM address WHERE ID = ?");
            preparedStatement.setLong(1, address.getId());
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
	public List<Address> getAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Address address = null;
        List<Address> addresses = new ArrayList<>();
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM address");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                address = new Address();
                address.setId(resultSet.getLong("ID"));
                address.setCities(Cities.valueOf(resultSet.getString("CITIES")));
                address.setStreet(resultSet.getString("STREET"));
                address.setPhone(resultSet.getString("PHONE"));
                address.setHouseNumber(resultSet.getInt("HOUSE_NUMBER"));
                addresses.add(address);
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

        return addresses;	
	}


}

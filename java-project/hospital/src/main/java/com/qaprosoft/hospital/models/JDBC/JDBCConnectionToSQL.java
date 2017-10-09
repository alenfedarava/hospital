package com.qaprosoft.hospital.models.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import com.qaprosoft.hospital.models.connectionpool.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JDBCConnectionToSQL {
	private static final Logger LOGGER = LogManager.getLogger(JDBCConnectionToSQL.class);
	
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

	public void readDB throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager
                    .getConnection(url, user, password);
			statement = connect.createStatement(); 
			resultSet = statement
                    .executeQuery("select * from hospital.Address");
            writeResultSet(resultSet);
		}


	}

}

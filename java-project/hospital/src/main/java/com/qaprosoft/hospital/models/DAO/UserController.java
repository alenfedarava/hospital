package com.qaprosoft.hospital.models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserController extends AbstractController{

	public static final String SELECT_ALL_USERS = "SELECT * FROM SHEMA.USER";

    @Override
    public List<Planet> getAll() {
        List<User> lst = new LinkedList<>();
        PreparedStatement ps = getPrepareStatement(SELECT_ALL_PLANET);
        try {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                User user = new User();
                planet.setId(rs.getInt(1));
                planet.setName(rs.getString(2));
                lst.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closePrepareStatement(ps);
        }

        return lst;
    }

    @Override
    public Planet getEntityById(Integer id) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public boolean create(Planet entity) {
        return false;
    }
}

}

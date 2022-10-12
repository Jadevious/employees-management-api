package com.kainos.ea.dao;

import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.User;
import com.kainos.ea.util.DatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> getUsers(Connection c) throws SQLException, DatabaseConnectionException {
        Statement st = c.createStatement();
        PreparedStatement statement = c.prepareStatement("SELECT id, username, password FROM users ");

        ResultSet rs = statement.executeQuery();

        if (!rs.isBeforeFirst()) {
            return null;
        }

        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(new User(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)));
        }
        return users;
    }
}

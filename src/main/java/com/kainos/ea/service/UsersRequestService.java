package com.kainos.ea.service;

import com.kainos.ea.dao.UserDao;
import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.Job;
import com.kainos.ea.models.User;
import com.kainos.ea.util.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UsersRequestService {
    public UserDao dao;
    public DatabaseConnector connector;
    public UsersRequestService(UserDao dao, DatabaseConnector connector) {
        this.dao = dao;
        this.connector = connector;
    }

    public List<User> getUsers() throws DatabaseConnectionException, SQLException {
        return dao.getUsers(connector.getConnection());
    }

    public List<User> findUser(String username) throws DatabaseConnectionException, SQLException {
        return dao.findUser(username, connector.getConnection());
    }
}

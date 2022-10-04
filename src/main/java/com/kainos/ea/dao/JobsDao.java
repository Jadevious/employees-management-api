package com.kainos.ea.dao;

import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.Job;
import com.kainos.ea.util.DatabaseConnector;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class JobsDao {
    public List<Job> getJobs(Connection c) throws SQLException, DatabaseConnectionException {
        Statement st = c.createStatement();
        PreparedStatement statement = c.prepareStatement("SELECT id, name, job_description, capability FROM job_roles");
        ResultSet rs = statement.executeQuery();

        if (!rs.isBeforeFirst()) {
            return null;
        }

        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new Job(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
        }
        return jobs;
    }
}

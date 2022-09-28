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
        PreparedStatement statement = c.prepareStatement("SELECT * FROM job_roles");
        ResultSet rs = statement.executeQuery();

        if (!rs.isBeforeFirst()) {
            return null;
        }

        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            Job newJob = new Job();
            newJob.setId(rs.getInt((1)));
            newJob.setName(rs.getString(2));
            newJob.setJob_description(rs.getString(3));
            jobs.add(newJob);
        }
        return jobs;
    }

}

package com.kainos.ea.dao;

import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.Band;
import com.kainos.ea.models.Capability;
import com.kainos.ea.models.Job;
import com.kainos.ea.models.JobRequest;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class JobsDao {
    public List<Job> getJobs(Connection c) throws SQLException, DatabaseConnectionException {
        Statement st = c.createStatement();
        PreparedStatement statement = c.prepareStatement("SELECT id, job_roles.name, description, specification, responsibilities, bands.name, capabilities.name FROM job_roles JOIN bands USING(id) JOIN capabilities USING(id)");

        ResultSet rs = statement.executeQuery();

        if (!rs.isBeforeFirst()) {
            return null;
        }

        List<Job> jobs = new ArrayList<>();
        while (rs.next()) {
            jobs.add(new Job(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)));
        }
        return jobs;
    }

    public List<Band> getBands(Connection c) throws SQLException {
        Statement st = c.createStatement();
        PreparedStatement statement = c.prepareStatement("SELECT id, name FROM bands");

        ResultSet rs = statement.executeQuery();

        if (!rs.isBeforeFirst()) {
            return null;
        }

        List<Band> bands = new ArrayList<>();
        while (rs.next()) {
            bands.add(new Band(rs.getInt(1),
                    rs.getString(2)));
        }
        return bands;
    }

    public List<Capability> getCapabilities(Connection c) throws SQLException {
        Statement st = c.createStatement();
        PreparedStatement statement = c.prepareStatement("SELECT id, name FROM capabilities");

        ResultSet rs = statement.executeQuery();

        if (!rs.isBeforeFirst()) {
            return null;
        }

        List<Capability> capabilities = new ArrayList<>();
        while (rs.next()) {
            capabilities.add(new Capability(rs.getInt(1),
                    rs.getString(2)));
        }
        return capabilities;
    }

    public int insertNewRole(JobRequest role, Connection c) throws SQLException{
        int roleNo = 0;
        String insertNewRoleQuery = "insert into job_roles (name, description, specification, responsibilities, capability, band_id)"
                + " values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStmt = c.prepareStatement(insertNewRoleQuery, Statement.RETURN_GENERATED_KEYS);
        preparedStmt.setString(1, role.getName());
        preparedStmt.setString(2, role.getDescription());
        preparedStmt.setString(3, role.getSpecification());
        preparedStmt.setString(4, role.getResponsibilities());
        preparedStmt.setInt(5, role.getCapability_id());
        preparedStmt.setInt(6, role.getBand_id());

        int affectedRows = preparedStmt.executeUpdate();

        if (affectedRows == 0) {
            throw new SQLException("Creating new role failed, no rows affected.");
        }

        try (ResultSet rs = preparedStmt.getGeneratedKeys()) {
            if (rs.next()) {
                roleNo = rs.getInt(1);
            }
        }

        return roleNo;
    }
}

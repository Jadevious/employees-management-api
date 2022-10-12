package com.kainos.ea.dao;

import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.Band;
import com.kainos.ea.models.Capability;
import com.kainos.ea.models.Job;
import com.kainos.ea.util.DatabaseConnector;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class JobsDao {
    public List<Job> getJobs(Connection c) throws SQLException, DatabaseConnectionException {
        Statement st = c.createStatement();
        PreparedStatement statement = c.prepareStatement("SELECT id, job_roles.name, description, specification, responsibilities, bands.name, capability " +
                "FROM job_roles JOIN bands USING(id)");

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

    public Job getJob(int id, Connection c) throws SQLException, DatabaseConnectionException {
        Statement st = c.createStatement ();

        PreparedStatement statement = c.prepareStatement ("SELECT job_roles.id, job_roles.name, description, specification, responsibilities, capability, bands.name  FROM job_roles JOIN bands ON (job_roles.band_id = bands.id) WHERE job_roles.id =" + id);

        ResultSet rs = statement.executeQuery ();

        if (!rs.isBeforeFirst ()) {
            return null;
        }

        Job job = null;
        while (rs.next ()) {
            job = new Job (rs.getInt (1), rs.getString (2), rs.getString (3), rs.getString (4), rs.getString (5), rs.getString(6), rs.getString (7));
        }
        return job;
    }
}

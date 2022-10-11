package com.kainos.ea.service;

import com.kainos.ea.dao.JobsDao;
import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.Band;
import com.kainos.ea.models.Capability;
import com.kainos.ea.models.Job;
import com.kainos.ea.util.DatabaseConnector;

import java.sql.SQLException;

import java.util.List;

public class JobsRequestService {
    public JobsDao dao;
    public DatabaseConnector connector;
    public JobsRequestService(JobsDao dao, DatabaseConnector connector) {
        this.dao = dao;
        this.connector = connector;
    }

    public List<Job> getJobs() throws DatabaseConnectionException, SQLException {
        return dao.getJobs(connector.getConnection());
    }

    public List<Band> getBands() throws DatabaseConnectionException, SQLException {
        return dao.getBands(connector.getConnection());
    }

    public List<Capability> getCapabilities() throws DatabaseConnectionException, SQLException {
        return dao.getCapabilities(connector.getConnection());
    }
}

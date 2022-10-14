package com.kainos.ea.service;

import com.kainos.ea.dao.JobsDao;
import com.kainos.ea.exception.DatabaseConnectionException;

import com.kainos.ea.models.Band;
import com.kainos.ea.models.Capability;
import com.kainos.ea.models.Job;
import com.kainos.ea.models.JobRequest;

import com.kainos.ea.models.*;

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

    public int insertNewRole(JobRequest role) throws DatabaseConnectionException, SQLException {
        return dao.insertNewRole(role, connector.getConnection());
    }


    public Job getJobById(int id) throws DatabaseConnectionException, SQLException {
        return dao.getJob(id, connector.getConnection());
    }

    public String editJobRole(JobEditRequest role) throws DatabaseConnectionException, SQLException {
        return dao.editJobRole(role, connector.getConnection());
    }

}

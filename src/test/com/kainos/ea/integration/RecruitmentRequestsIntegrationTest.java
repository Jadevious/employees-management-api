package com.kainos.ea.integration;

import com.kainos.ea.models.Job;
import com.kainos.ea.nameApplication;
import com.kainos.ea.nameConfiguration;
import com.kainos.ea.service.JobsRequestService;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.kainos.ea.util.DatabaseConnector;
import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.dao.JobsDao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.*;

@ExtendWith(DropwizardExtensionsSupport.class)
public class RecruitmentRequestsIntegrationTest {

    static final DropwizardAppExtension<nameConfiguration> APP = new DropwizardAppExtension<>(
            nameApplication.class, null,
            new ResourceConfigurationSourceProvider()
    );



    @Test
    void getJobs_shouldReturnListOfJobs() {
        List<Job> response = APP.client().target("http://localhost:8080/api/job-roles")
                .request()
                .get(List.class);

        Assertions.assertTrue(response.size() > 0);
    }
    @Test
    void deleteJobRole_shouldReturnJobSuccessfullyDeletedMessage() throws SQLException, DatabaseConnectionException {
        Job job =new Job(
                "Marketing Operations Manager",
                "Develops Software for Kainos",
                "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf",
                "Experience of building and testing modern software applications",
                6,
                "Business Development and Marketing");
        DatabaseConnector databaseConnector = new DatabaseConnector();
        Connection c =databaseConnector.getConnection();
        String sql = "INSERT INTO job_roles (name,description,specification,responsibilities,capability,band_id) VALUES(?,?,?,?,?,?);";
        PreparedStatement InsertStatement = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        InsertStatement.setString(1, job.getName());
        InsertStatement.setString(2, job.getDescription());
        InsertStatement.setString(3, job.getSpecification());
        InsertStatement.setString(4, job.getResponsibilities());
        InsertStatement.setString(5, job.getCapability());
        InsertStatement.setInt(6, job.getBandID());

        InsertStatement.executeUpdate();
        ResultSet rs = InsertStatement.getGeneratedKeys();
        int insertedJobID=0;
        if (rs.next()){
            insertedJobID = rs.getInt(1);
        }
        String actualResponse = APP.client().target("http://localhost:8080/api/delete-job/"+insertedJobID)
                .request()
                .delete(String.class);
        String expectedResponse = "This job role has been deleted: ID: "+insertedJobID+", Name: "+job.getName();
        Assertions.assertEquals(actualResponse,expectedResponse);
    }
}

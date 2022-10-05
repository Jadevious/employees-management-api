package com.kainos.ea.controller;

import com.kainos.ea.dao.JobsDao;
import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.service.JobsRequestService;
import com.kainos.ea.util.DatabaseConnector;

import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/api")
public class RecruitmentRequests {
    private static JobsRequestService jobService;

    public RecruitmentRequests() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        jobService = new JobsRequestService(new JobsDao(), databaseConnector);
    }

    @GET
    @Path("/job-roles")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoles() {
        try {
            return Response.ok(jobService.getJobs()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println("Error getting jobs: " + e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }
}

package com.kainos.ea.controller;

import com.kainos.ea.dao.JobsDao;
import com.kainos.ea.exception.*;
import com.kainos.ea.models.Job;
import com.kainos.ea.models.JobRequest;
import com.kainos.ea.service.JobsRequestService;
import com.kainos.ea.util.DatabaseConnector;
import com.kainos.ea.validator.JobValidator;

import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.sql.SQLException;

@Path("/api")
public class RecruitmentRequests {
    private static JobsRequestService jobService;
    private static JobValidator jobValidator;

    public RecruitmentRequests() {
        DatabaseConnector databaseConnector = new DatabaseConnector();
        jobService = new JobsRequestService(new JobsDao(), databaseConnector);
        jobValidator = new JobValidator();
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

    @GET
    @Path("/bands")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBands() {
        try {
            return Response.ok(jobService.getBands()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println("Error getting bands: " + e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @GET
    @Path("/capabilities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCapabilities() {
        try {
            return Response.ok(jobService.getCapabilities()).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println("Error getting capabilities: " + e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @POST
    @Path("/admin/new-role")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public static Response createNewRole(JobRequest role) throws DatabaseConnectionException {
        try {
            if (jobValidator.isValidRole(role)) {
                try {
                    int id = jobService.insertNewRole(role);
                    return Response.status(HttpStatus.CREATED_201).entity(id).build();
                } catch (Exception e) {
                    System.out.println(e);
                    return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
                }
            } else {
                return Response.status(HttpStatus.BAD_REQUEST_400).build();
            }
        } catch (NameTooLongException | DescriptionTooLongException | SpecificationTooLongException | ResponsibilitiesTooLongException e) {
            return Response.status(HttpStatus.BAD_REQUEST_400).build();
        }
    }
}

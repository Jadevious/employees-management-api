package com.kainos.ea.controller;

import com.kainos.ea.dao.JobsDao;
import com.kainos.ea.exception.*;
import com.kainos.ea.models.JobEditRequest;
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

    @GET
    @Path("/job-roles/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJobRoleById(@PathParam("id") int id) {
        try {
            return Response.ok(jobService.getJobById (id)).build();
        } catch (SQLException | DatabaseConnectionException e) {
            System.out.println("Error getting jobs: " + e);
            return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
        }
    }

    @PUT
    @Path("/admin/edit-role")
    @Consumes(MediaType.APPLICATION_JSON)
    public static Response editRole(JobEditRequest request) throws DatabaseConnectionException {
        try {
            if (jobValidator.isValidRole(request)) {
                try {
                    return Response.status(HttpStatus.OK_200).entity(jobService.editJobRole (request)).build();
                } catch (Exception e) {
                    System.out.println(e);
                    return Response.status(HttpStatus.INTERNAL_SERVER_ERROR_500).build();
                }
            } else {
                return Response.status(HttpStatus.BAD_REQUEST_400).build();
            }
        } catch (NameTooLongException | DescriptionTooLongException | SpecificationTooLongException |
                 ResponsibilitiesTooLongException e) {
            return Response.status(HttpStatus.BAD_REQUEST_400).build();
        }
    }

}

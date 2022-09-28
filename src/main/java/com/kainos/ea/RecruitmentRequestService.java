package com.kainos.ea;

import com.kainos.ea.db.JobsDb;
import com.kainos.ea.models.Job;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api")
public class RecruitmentRequestService {

    @GET
    @Path("/jobs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Job> getMsg() {
        try {
            Connection c = JobsDb.getConnection();
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
        } catch (SQLException e) {
            System.err.println("Exception while getting job list: " + e);
            return null;
        }
    }

//    @GET
//    @Path("/employees/{dept}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Employee> getEmployeesByDept(@PathParam("dept") String dept) {
//
//        List<Employee> myEmployees = GetEmployeeByDept.execute(dept);
//        return myEmployees;
//    }
}
package com.kainos.ea.service;

import com.kainos.ea.dao.JobsDao;
import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.Band;
import com.kainos.ea.models.Capability;
import com.kainos.ea.models.Job;
import com.kainos.ea.models.JobEditRequest;
import com.kainos.ea.util.DatabaseConnector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ServiceTests {

    JobsDao jobsDao = Mockito.mock(JobsDao.class);
    DatabaseConnector databaseConnector = Mockito.mock(DatabaseConnector.class);

    JobsRequestService jobsRequestService = new JobsRequestService(jobsDao, databaseConnector);

    Connection conn;

    @Test
    void getJobs_shouldReturnListOfJobs_whenDaoReturnsListOfJobs() throws DatabaseConnectionException, SQLException {
        List<Job> expected = new ArrayList<Job>();
        expected.add(new Job(
                1,
                "Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                "Apprentice",
                "Engineering"
        ));


        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.getJobs(conn)).thenReturn(expected);

        List<Job> actual = jobsRequestService.getJobs();

        assertEquals(actual, expected);
    }

    @Test
    void getJobs_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException, DatabaseConnectionException {
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.getJobs(conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobsRequestService.getJobs());
    }
    @Test
    void getBands_shouldReturnListOfBands_whenDaoReturnsListOfBands() throws DatabaseConnectionException, SQLException {
        List<Band> expected = new ArrayList<Band>();
        expected.add(new Band(
                1,
                "Associate"
        ));

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.getBands(conn)).thenReturn(expected);

        List<Band> actual = jobsRequestService.getBands();

        assertEquals(actual, expected);
    }

    @Test
    void getCapabilities_shouldReturnListOfCapabilities_whenDaoReturnsListOfCapabilities() throws DatabaseConnectionException, SQLException {
        List<Capability> expected = new ArrayList<Capability>();
        expected.add(new Capability(
                1,
                "Experience Design"
        ));

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.getCapabilities(conn)).thenReturn(expected);

        List<Capability> actual = jobsRequestService.getCapabilities();

        assertEquals(actual, expected);
    }

    @Test
    void getJobById_shouldReturnJob_whenDaoReturnsJob() throws DatabaseConnectionException, SQLException {
        Job expected = (new Job(
                1,
                "Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                "Apprentice",
                "Engineering"));

        int id = 1;

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.getJob(id, conn)).thenReturn(expected);

        Job actual = jobsRequestService.getJobById (id);

        assertEquals(actual, expected);
    }
    @Test
    void getJobsById_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException, DatabaseConnectionException {
        int id = 1;
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.getJob(id, conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobsRequestService.getJobById (id));
    }

    @Test
    void editJob_shouldReturnSuccessfullyUpdatedMessage_whenDaoReturnsJob() throws DatabaseConnectionException, SQLException {
        JobEditRequest expected = (new JobEditRequest (
                1,
                "Software Developer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                1));

        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.editJobRole (expected, conn)).thenReturn("Role successfully updated");

        String actual = jobsRequestService.editJobRole (expected);

        assertEquals(actual, "Role successfully updated" );
    }

    @Test
    void editJob_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException, DatabaseConnectionException {
        JobEditRequest expected = (new JobEditRequest (
                1,
                "Software Developer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                1));
        Mockito.when(databaseConnector.getConnection()).thenReturn(conn);
        Mockito.when(jobsDao.editJobRole (expected, conn)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobsRequestService.editJobRole (expected));
    }
}

package com.kainos.ea.service;

import com.kainos.ea.dao.JobsDao;
import com.kainos.ea.exception.DatabaseConnectionException;
import com.kainos.ea.models.Job;
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
class JobsRequestServiceTest {

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
                "Apprentice"
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
}

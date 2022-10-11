package com.kainos.ea.integration;

import com.kainos.ea.models.Job;
import com.kainos.ea.nameApplication;
import com.kainos.ea.nameConfiguration;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

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
    void deleteJobRole_shouldReturnJobSuccessfullyDeletedMessage() {
        Job job =new Job(
                1,
                "Software Engineer",
                "Develops Software for Kainos",
                "Apprentice",
                "Experience of building and testing modern software applications",
                "Engineering");
        String actualResponse = APP.client().target("http://localhost:8080/api/delete-job/"+job.getId())
                .request()
                .delete(String.class);
        String expectedResponse = "This job role has been deleted: ID: "+job.getId()+", Name: "+job.getName();
        Assertions.assertEquals(actualResponse,expectedResponse);
    }
}

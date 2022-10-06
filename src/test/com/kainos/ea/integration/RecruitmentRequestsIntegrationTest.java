package com.kainos.ea.integration;

import com.kainos.ea.models.CareerLattice;
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
    void getEmployees_shouldReturnListOfEmployees() {
        List<Job> response = APP.client().target("http://localhost:8080/api/job-roles")
                .request()
                .get(List.class);

        Assertions.assertTrue(response.size() > 0);
    }

    @Test
    void getCareerLattice_shouldReturnListOfCareerLattices() {
        List<CareerLattice> response = APP.client().target("http://localhost:8080/api/role-matrix")
                .request()
                .get(List.class);

        Assertions.assertTrue(response.size() > 0);
    }
}

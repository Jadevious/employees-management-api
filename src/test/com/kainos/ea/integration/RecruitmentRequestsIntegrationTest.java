package com.kainos.ea.integration;

import com.kainos.ea.models.Band;
import com.kainos.ea.models.Capability;
import com.kainos.ea.models.Job;
import com.kainos.ea.models.JobRequest;
import com.kainos.ea.nameApplication;
import com.kainos.ea.nameConfiguration;
import io.dropwizard.testing.junit5.DropwizardAppExtension;
import io.dropwizard.testing.junit5.DropwizardExtensionsSupport;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
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
    void getBands_shouldReturnListOfBands() {
        List<Band> response = APP.client().target("http://localhost:8080/api/bands")
                .request()
                .get(List.class);

        Assertions.assertTrue(response.size() > 0);
    }

    @Test
    void getCapabilities_shouldReturnListOfCapabilities() {
        List<Capability> response = APP.client().target("http://localhost:8080/api/capabilities")
                .request()
                .get(List.class);

        Assertions.assertTrue(response.size() > 0);
    }

    @Test
    void postNewRole_shouldReturnIdOfNewRole() {
        JobRequest jobRequest = new JobRequest(
                "Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client().target("http://localhost:8080/api/admin/new-role")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(Integer.class);

        Assertions.assertNotNull(response);
    }

    @Test
    void postAdminNewRole_shouldReturnError400_whenNameTooLong() {
        JobRequest jobRequest = new JobRequest(
                "Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client().target("http://localhost:8080/api/admin/new-role")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE)).getStatus();

        Assertions.assertEquals(response, 400);
    }

    @Test
    void postAdminNewRole_shouldReturnError400_whenDescriptionTooLong() {
        JobRequest jobRequest = new JobRequest(
                "Software Engineer",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in scelerisque mauris. Sed elementum mi a bibendum suscipit. Phasellus ante justo, mollis et augue at, aliquam tincidunt sem. Nulla facilisi. Cras nec nibh eget metus blandit pretium. Proin vitae gravida leo, et molestie lorem. In ornare sit amet diam vel gravida.\n" +
                        "\n" +
                        "Aenean lacinia, ligula eu malesuada commodo, nisi enim lacinia purus, ut aliquet mi nisl quis urna. Integer vel justo et justo semper varius at a nibh. Fusce ut semper odio. Nulla egestas neque laoreet posuere iaculis. Vestibulum tempor massa at velit viverra, ullamcorper dictum sem pharetra. Suspendisse leo sem, consectetur in dui quis, convallis rutrum sem. Nunc felis quam, sollicitudin ac posuere eget, commodo eget quam. Donec malesuada semper purus, eget aliquet risus mattis ac. Integer semper sem sed tempor dictum. Donec accumsan neque ut sapien pellentesque ornare. Nulla auctor sit amet orci eu auctor. Duis lobortis cursus lectus, nec convallis nisl posuere ac. Aliquam condimentum non turpis vitae lacinia. Pellentesque maximus pharetra quam et condimentum. Morbi quis rhoncus tortor.\n",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client().target("http://localhost:8080/api/admin/new-role")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE)).getStatus();

        Assertions.assertEquals(response, 400);
    }

    @Test
    void postAdminNewRole_shouldReturnError400_whenSpecificationTooLong() {
        JobRequest jobRequest = new JobRequest(
                "Software Engineer",
                "Develops Software for Kainos",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in scelerisque mauris. Sed elementum mi a bibendum suscipit. Phasellus ante justo, mollis et augue at, aliquam tincidunt sem. Nulla facilisi. Cras nec nibh eget metus blandit pretium. Proin vitae gravida leo, et molestie lorem. In ornare sit amet diam vel gravida.\n" +
                        "\n" +
                        "Aenean lacinia, ligula eu malesuada commodo, nisi enim lacinia purus, ut aliquet mi nisl quis urna. Integer vel justo et justo semper varius at a nibh. Fusce ut semper odio. Nulla egestas neque laoreet posuere iaculis. Vestibulum tempor massa at velit viverra, ullamcorper dictum sem pharetra. Suspendisse leo sem, consectetur in dui quis, convallis rutrum sem. Nunc felis quam, sollicitudin ac posuere eget, commodo eget quam. Donec malesuada semper purus, eget aliquet risus mattis ac. Integer semper sem sed tempor dictum. Donec accumsan neque ut sapien pellentesque ornare. Nulla auctor sit amet orci eu auctor. Duis lobortis cursus lectus, nec convallis nisl posuere ac. Aliquam condimentum non turpis vitae lacinia. Pellentesque maximus pharetra quam et condimentum. Morbi quis rhoncus tortor.\n",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client().target("http://localhost:8080/api/admin/new-role")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE)).getStatus();

        Assertions.assertEquals(response, 400);
    }

    @Test
    void postAdminNewRole_shouldReturnError400_whenResponsibilitiesTooLong() {
        JobRequest jobRequest = new JobRequest(
                "Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in scelerisque mauris. Sed elementum mi a bibendum suscipit. Phasellus ante justo, mollis et augue at, aliquam tincidunt sem. Nulla facilisi. Cras nec nibh eget metus blandit pretium. Proin vitae gravida leo, et molestie lorem. In ornare sit amet diam vel gravida.\n" +
                        "\n" +
                        "Aenean lacinia, ligula eu malesuada commodo, nisi enim lacinia purus, ut aliquet mi nisl quis urna. Integer vel justo et justo semper varius at a nibh. Fusce ut semper odio. Nulla egestas neque laoreet posuere iaculis. Vestibulum tempor massa at velit viverra, ullamcorper dictum sem pharetra. Suspendisse leo sem, consectetur in dui quis, convallis rutrum sem. Nunc felis quam, sollicitudin ac posuere eget, commodo eget quam. Donec malesuada semper purus, eget aliquet risus mattis ac. Integer semper sem sed tempor dictum. Donec accumsan neque ut sapien pellentesque ornare. Nulla auctor sit amet orci eu auctor. Duis lobortis cursus lectus, nec convallis nisl posuere ac. Aliquam condimentum non turpis vitae lacinia. Pellentesque maximus pharetra quam et condimentum. Morbi quis rhoncus tortor.\n",
                1,
                2
        );

        int response = APP.client().target("http://localhost:8080/api/admin/new-role")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE)).getStatus();

        Assertions.assertEquals(response, 400);
    }

    @Test
    void postAdminNewRole_shouldReturnError400_whenNoNameIncluded() {
        JobRequest jobRequest = new JobRequest(
                "",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client().target("http://localhost:8080/api/admin/new-role")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE)).getStatus();

        Assertions.assertEquals(response, 400);
    }
}

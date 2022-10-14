package com.kainos.ea.integration;

import com.kainos.ea.models.Band;
import com.kainos.ea.models.Capability;
import com.kainos.ea.models.Job;
import com.kainos.ea.models.JobRequest;

import com.kainos.ea.models.JobEditRequest;

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
        JobRequest jobRequest = new JobRequest (
                "Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client ().target ("http://localhost:8080/api/admin/new-role")
                .request()
                .post(Entity.entity(jobRequest, MediaType.APPLICATION_JSON_TYPE))
                .readEntity(Integer.class);

        Assertions.assertNotNull(response);
    }


    @Test
    void getJobById_shouldReturnJobs() {
        int id = 1;
        Job response = APP.client().target("http://localhost:8080/api/job-roles/"+ id)
                .request()
                .get(Job.class);

        Assertions.assertTrue(response != null);
    }

    @Test
    void editJobRole_shouldReturnSuccessfullyUpdatedMessage() {
        JobEditRequest editRequest = new JobEditRequest (1, "Software Engineer",
                "You will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. Undertake extensive training to set you off on the right foot, " +
                        "you will quickly work as a part of a team in developing solutions within our real projects and " +
                        "learn all about our development languages, projects and technologies. You will be fully supported " +
                        "by experienced colleagues in the team, as well as an experienced mentor, who will provide training " +
                        "and mentoring throughout your st", "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf",
                "As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. extensive training to set you off on the right foot, you will quickly work " +
                        "as a part of a team in developing solutions within our real projects, learning all about our development " +
                        "languages, projects and technologies. You will be fully supported by experienced colleagues in the team " +
                        "as well as an experienced mentor, who will provide trai",1,1);

        String response = APP.client().target("http://localhost:8080/api/admin/edit-role")
                .request()
                .put(Entity.entity (editRequest, MediaType.APPLICATION_JSON_TYPE))
                .readEntity (String.class);

        System.out.println (response);
        Assertions.assertEquals("Role successfully updated", response);
    }

    @Test
    void editRole_shouldReturnError400_whenNameTooLong() {
        JobEditRequest editRequest = new JobEditRequest (1, "Software EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware",
                "You will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. Undertake extensive training to set you off on the right foot, " +
                        "you will quickly work as a part of a team in developing solutions within our real projects and " +
                        "learn all about our development languages, projects and technologies. You will be fully supported " +
                        "by experienced colleagues in the team, as well as an experienced mentor, who will provide training " +
                        "and mentoring throughout your st", "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf",
                "As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. extensive training to set you off on the right foot, you will quickly work " +
                        "as a part of a team in developing solutions within our real projects, learning all about our development " +
                        "languages, projects and technologies. You will be fully supported by experienced colleagues in the team " +
                        "as well as an experienced mentor, who will provide trai",1,1);

        int response = APP.client().target("http://localhost:8080/api/admin/edit-role")
                .request()
                .put(Entity.entity(JobEditRequest.class, MediaType.APPLICATION_JSON_TYPE)).getStatus();

        Assertions.assertEquals(response, 400);
    }
    @Test
    void editRole_shouldReturnError400_whenDescriptionTooLong() {
        JobEditRequest editRequest = new JobEditRequest (1, "Software Engineer",
                "You will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. Undertake extensive training to set you off on the right foot, " +
                        "you will quickly work as a part of a team in developing solutions within our real projects and " +
                        "learn all about our development languages, projects and technologies. You will be fully supported " +
                        "by experienced colleagues in the team, as well as an experienced mentor, who will provide training " +
                        "and mentoring throughout your st"+ "and mentoring throughout your st"+ "and mentoring throughout your st"+
                        "and mentoring throughout your st"+ "and mentoring throughout your st"+ "and mentoring throughout your st"+
                        "and mentoring throughout your st"+ "and mentoring throughout your st"+ "and mentoring throughout your st"+
                        "and mentoring throughout your st"+ "and mentoring throughout your st"+ "and mentoring throughout your st"+
                        "and mentoring throughout your st"+ "and mentoring throughout your st"+ "and mentoring throughout your st"+
                        "and mentoring throughout your st"+ "and mentoring throughout your st"+ "and mentoring throughout your st"+
                        "and mentoring throughout your st", "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf",
                "As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. extensive training to set you off on the right foot, you will quickly work " +
                        "as a part of a team in developing solutions within our real projects, learning all about our development " +
                        "languages, projects and technologies. You will be fully supported by experienced colleagues in the team " +
                        "as well as an experienced mentor, who will provide trai",1,1);

        int response = APP.client().target("http://localhost:8080/api/admin/edit-role")
                .request()
                .put(Entity.entity(JobEditRequest.class, MediaType.APPLICATION_JSON_TYPE)).getStatus();

        Assertions.assertEquals(response, 400);
    }

    @Test
    void postAdminNewRole_shouldReturnError400_whenDescriptionTooLong() {
        JobRequest jobRequest = new JobRequest (
                "Software Engineer",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in scelerisque mauris. Sed elementum mi a bibendum suscipit. Phasellus ante justo, mollis et augue at, aliquam tincidunt sem. Nulla facilisi. Cras nec nibh eget metus blandit pretium. Proin vitae gravida leo, et molestie lorem. In ornare sit amet diam vel gravida.\n" +
                        "\n" +
                        "Aenean lacinia, ligula eu malesuada commodo, nisi enim lacinia purus, ut aliquet mi nisl quis urna. Integer vel justo et justo semper varius at a nibh. Fusce ut semper odio. Nulla egestas neque laoreet posuere iaculis. Vestibulum tempor massa at velit viverra, ullamcorper dictum sem pharetra. Suspendisse leo sem, consectetur in dui quis, convallis rutrum sem. Nunc felis quam, sollicitudin ac posuere eget, commodo eget quam. Donec malesuada semper purus, eget aliquet risus mattis ac. Integer semper sem sed tempor dictum. Donec accumsan neque ut sapien pellentesque ornare. Nulla auctor sit amet orci eu auctor. Duis lobortis cursus lectus, nec convallis nisl posuere ac. Aliquam condimentum non turpis vitae lacinia. Pellentesque maximus pharetra quam et condimentum. Morbi quis rhoncus tortor.\n",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client ().target ("http://localhost:8080/api/admin/new-role")
                .request ()
                .post (Entity.entity (jobRequest, MediaType.APPLICATION_JSON_TYPE)).getStatus ();

        Assertions.assertEquals(response, 400);
    }
        @Test
    void editRole_shouldReturnError400_whenSpecificationTooLong() {
        JobEditRequest editRequest = new JobEditRequest (1, "Software Engineer",
                "You will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. Undertake extensive training to set you off on the right foot, " +
                        "you will quickly work as a part of a team in developing solutions within our real projects and " +
                        "learn all about our development languages, projects and technologies. You will be fully supported " +
                        "by experienced colleagues in the team, as well as an experienced mentor, who will provide training " +
                        "and mentoring throughout your st", "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUfhttps://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf",
                "As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. extensive training to set you off on the right foot, you will quickly work " +
                        "as a part of a team in developing solutions within our real projects, learning all about our development " +
                        "languages, projects and technologies. You will be fully supported by experienced colleagues in the team " +
                        "as well as an experienced mentor, who will provide trai",1,1);

        int response = APP.client().target("http://localhost:8080/api/admin/edit-role")
                .request()
                .put(Entity.entity(JobEditRequest.class, MediaType.APPLICATION_JSON_TYPE)).getStatus();
        Assertions.assertEquals(response, 400);
    }

    @Test
    void postAdminNewRole_shouldReturnError400_whenSpecificationTooLong() {
        JobRequest jobRequest = new JobRequest (
                "Software Engineer",
                "Develops Software for Kainos",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur in scelerisque mauris. Sed elementum mi a bibendum suscipit. Phasellus ante justo, mollis et augue at, aliquam tincidunt sem. Nulla facilisi. Cras nec nibh eget metus blandit pretium. Proin vitae gravida leo, et molestie lorem. In ornare sit amet diam vel gravida.\n" +
                        "\n" +
                        "Aenean lacinia, ligula eu malesuada commodo, nisi enim lacinia purus, ut aliquet mi nisl quis urna. Integer vel justo et justo semper varius at a nibh. Fusce ut semper odio. Nulla egestas neque laoreet posuere iaculis. Vestibulum tempor massa at velit viverra, ullamcorper dictum sem pharetra. Suspendisse leo sem, consectetur in dui quis, convallis rutrum sem. Nunc felis quam, sollicitudin ac posuere eget, commodo eget quam. Donec malesuada semper purus, eget aliquet risus mattis ac. Integer semper sem sed tempor dictum. Donec accumsan neque ut sapien pellentesque ornare. Nulla auctor sit amet orci eu auctor. Duis lobortis cursus lectus, nec convallis nisl posuere ac. Aliquam condimentum non turpis vitae lacinia. Pellentesque maximus pharetra quam et condimentum. Morbi quis rhoncus tortor.\n",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        int response = APP.client ().target ("http://localhost:8080/api/admin/new-role")
                .request ()
                .post (Entity.entity (jobRequest, MediaType.APPLICATION_JSON_TYPE)).getStatus ();
        Assertions.assertEquals (response, 400);
    }

    @Test
    void editRole_shouldReturnError400_whenResponsibilitiesTooLong() {
        JobEditRequest editRequest = new JobEditRequest (1, "Software EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware EngineerSoftware",
                "You will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. Undertake extensive training to set you off on the right foot, " +
                        "you will quickly work as a part of a team in developing solutions within our real projects and " +
                        "learn all about our development languages, projects and technologies. You will be fully supported " +
                        "by experienced colleagues in the team, as well as an experienced mentor, who will provide training " +
                        "and mentoring throughout your st", "https://kainossoftwareltd.sharepoint.com/:b:/g/people/EbTM1UOLa0VBvOttkOL3ZNoB0sMjehxvkAaNQEj2dqKMbA?e=iXpeUf",
                "As an Apprentice Software Engineer with Kainos, you will work on projects where you can make a real difference to people’s lives – " +
                        "the lives of people you know. extensive training to set you off on the right foot, you will quickly work " +
                        "as a part of a team in developing solutions within our real projects, learning all about our development " +
                        "languages, projects and technologies. You will be fully supported by experienced colleagues in the team " +
                        "as well as an experienced mentor, who will provide trainnnnnnn",1,1);

        int response = APP.client().target("http://localhost:8080/api/admin/edit-role")
                .request()
                .put(Entity.entity(JobEditRequest.class, MediaType.APPLICATION_JSON_TYPE)).getStatus();

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

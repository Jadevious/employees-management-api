package com.kainos.ea.validator;

import com.kainos.ea.exception.NameTooLongException;
import com.kainos.ea.exception.DescriptionTooLongException;
import com.kainos.ea.exception.SpecificationTooLongException;
import com.kainos.ea.exception.ResponsibilitiesTooLongException;
import com.kainos.ea.models.JobRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobValidatorTest {

    JobValidator jobValidator = new JobValidator();

    @Test
    public void isValidRole_shouldReturnTrue_whenValidRole() throws NameTooLongException, SpecificationTooLongException, DescriptionTooLongException, ResponsibilitiesTooLongException {
        JobRequest jobRequest = new JobRequest(
                "Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        assertTrue(jobValidator.isValidRole(jobRequest));
    }

    @Test
    public void isValidRole_shouldReturnFalse_whenNameTooLong() throws NameTooLongException, SpecificationTooLongException, DescriptionTooLongException, ResponsibilitiesTooLongException {
        JobRequest jobRequest = new JobRequest(
                "Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer Software Engineer",
                "Develops Software for Kainos",
                "https://example.org",
                "Experience of building and testing modern software applications",
                1,
                2
        );

        assertThrows(NameTooLongException.class,
                () -> jobValidator.isValidRole(jobRequest));
    }

    @Test
    public void isValidRole_shouldReturnFalse_whenDescriptionTooLong() throws NameTooLongException, SpecificationTooLongException, DescriptionTooLongException, ResponsibilitiesTooLongException {
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

        assertThrows(DescriptionTooLongException.class,
                () -> jobValidator.isValidRole(jobRequest));
    }

    @Test
    public void isValidRole_shouldReturnFalse_whenSpecificationTooLong() throws NameTooLongException, SpecificationTooLongException, DescriptionTooLongException, ResponsibilitiesTooLongException {
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

        assertThrows(SpecificationTooLongException.class,
                () -> jobValidator.isValidRole(jobRequest));
    }

    @Test
    public void isValidRole_shouldReturnFalse_whenResponsibilitiesTooLong() throws NameTooLongException, SpecificationTooLongException, DescriptionTooLongException, ResponsibilitiesTooLongException {
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

        assertThrows(ResponsibilitiesTooLongException.class,
                () -> jobValidator.isValidRole(jobRequest));
    }
}

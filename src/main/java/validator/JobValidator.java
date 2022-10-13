package com.kainos.ea.validator;

import com.kainos.ea.exception.NameTooLongException;
import com.kainos.ea.exception.DescriptionTooLongException;
import com.kainos.ea.exception.SpecificationTooLongException;
import com.kainos.ea.exception.ResponsibilitiesTooLongException;

import com.kainos.ea.models.JobRequest;

public class JobValidator {
    public static boolean isValidRole(JobRequest role) throws NameTooLongException, DescriptionTooLongException, SpecificationTooLongException, ResponsibilitiesTooLongException {
        if (role.getName().length() > 50) {
            throw new NameTooLongException();
        }

        if (role.getDescription().length() > 500) {
            throw new DescriptionTooLongException();
        }

        if (role.getSpecification().length() > 255) {
            throw new SpecificationTooLongException();
        }

        if (role.getResponsibilities().length() > 500) {
            throw new ResponsibilitiesTooLongException();
        }

        return true;
    }
}

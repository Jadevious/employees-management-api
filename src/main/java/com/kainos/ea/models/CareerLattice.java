package com.kainos.ea.models;

import javax.validation.constraints.NotEmpty;

public class CareerLattice {

    @NotEmpty
    String job_role_name;

    @NotEmpty
    String capability;

    @NotEmpty
    String band_name;

    @NotEmpty
    String job_family_name;

    public String getJob_role_name() {
        return job_role_name;
    }

    public void setJob_role_name(String job_role_name) {
        this.job_role_name = job_role_name;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public String getBand_name() {
        return band_name;
    }

    public void setBand_name(String band_name) {
        this.band_name = band_name;
    }

    public String getJob_family_name() {
        return job_family_name;
    }

    public void setJob_family_name(String job_family_name) {
        this.job_family_name = job_family_name;
    }

    public CareerLattice (String job_role_name, String capability, String band_name, String job_family_name) {
        this.job_role_name = job_role_name;
        this.capability = capability;
        this.band_name = job_family_name;
        this.job_family_name = job_family_name;
    }

}

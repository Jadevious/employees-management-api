package com.kainos.ea.models;

import javax.validation.constraints.NotEmpty;

public class CareerLattice {

    @NotEmpty
    String jobRoleName;

    @NotEmpty
    String capability;

    @NotEmpty
    String bandName;

    @NotEmpty
    String jobFamilyName;

    public String getJobRoleName() {
        return jobRoleName;
    }

    public void setJobRoleName(String jobRoleName) {
        this.jobRoleName = jobRoleName;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public String getJobFamilyName() {
        return jobFamilyName;
    }

    public void setJobFamilyName(String jobFamilyName) {
        this.jobFamilyName = jobFamilyName;
    }

    public CareerLattice (String jobRoleName, String capability, String bandName, String jobFamilyName) {
        this.jobRoleName = jobRoleName;
        this.capability = capability;
        this.bandName = jobFamilyName;
        this.jobFamilyName = jobFamilyName;
    }

}

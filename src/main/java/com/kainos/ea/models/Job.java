package com.kainos.ea.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.checkerframework.checker.signature.qual.Identifier;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Job {

    @NotEmpty
    @Identifier
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String job_description;
    @NotEmpty
    private String job_responsibilities;

    public Job(int id, String name, String job_description, String job_responsibilities) {
        this.id = id;
        this.name = name;
        this.job_description = job_description;
        this.job_responsibilities = job_responsibilities;
    }

    public Job() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getJob_responsibilities() {
        return job_responsibilities;
    }

    public void setJob_responsibilities(String job_responsibilities) {
        this.job_responsibilities = job_responsibilities;
    }

}

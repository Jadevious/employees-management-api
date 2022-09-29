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

    @JsonCreator
    public Job(@JsonProperty("jobId") @Identifier int id, @JsonProperty("jobName") String name, @JsonProperty("job_description") String job_description) {
        this.id = id;
        this.name = name;
        this.job_description = job_description;
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
}
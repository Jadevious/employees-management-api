package com.kainos.ea.models;

import org.checkerframework.checker.signature.qual.Identifier;

import javax.validation.constraints.NotEmpty;

public class Job {

    @NotEmpty
    @Identifier
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String specification;
    @NotEmpty
    private String responsibilities;

    public Job(int id, String name, String description, String specification, String responsibilities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.specification = specification;
        this.responsibilities = responsibilities;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getResponsibilities() {return responsibilities;}

    public void setResponsibilities(String responsibilities) {this.responsibilities = responsibilities;}
}

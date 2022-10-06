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
    private String band;

    private String responsibilities;


    public Job(int id, String name, String description, String band) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.band = band;
    }

    public Job() {
    }

    public Job(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Job(int id, String name, String description, String responsibilities, String band) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.responsibilities = responsibilities;
        this.band = band;
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

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getResponsibilities() {return responsibilities;}

    public void setResponsibilities(String responsibilities) {this.responsibilities = responsibilities;}
}

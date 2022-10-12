package com.kainos.ea.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.checkerframework.checker.signature.qual.Identifier;

import javax.validation.constraints.NotEmpty;

public class JobRequest {

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String responsibilities;
    @NotEmpty
    private int capability_id;
    @NotEmpty
    private int band_id;

    @JsonCreator
    public JobRequest(@JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("responsibilities") String responsibilities,
                      @JsonProperty("capability") int capability_id, @JsonProperty("band_id") int band_id) {
        this.setName(name);
        this.setDescription(description);
        this.setResponsibilities(responsibilities);
        this.setCapability_id(capability_id);
        this.setBand_id(band_id);
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getResponsibilities() { return responsibilities; }

    public void setResponsibilities(String responsibilities) { this.responsibilities = responsibilities; }

    public int getCapability_id() { return capability_id; }

    public void setCapability_id(int capability_id) { this.capability_id = capability_id; }

    public int getBand_id() { return band_id; }

    public void setBand_id(int band_id) { this.band_id = band_id; }
}

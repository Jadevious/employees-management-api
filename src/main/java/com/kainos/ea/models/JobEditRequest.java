package com.kainos.ea.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotEmpty;

public class JobEditRequest extends JobRequest{


    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    @NotEmpty
    private int id;
    @JsonCreator
    public JobEditRequest(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("description") String description, @JsonProperty("specification") String specification,
                          @JsonProperty("responsibilities") String responsibilities, @JsonProperty("capability") int capability_id, @JsonProperty("band_id") int band_id) {
        super (name, description, specification, responsibilities, capability_id, band_id);
        this.setId (id);
    }


}

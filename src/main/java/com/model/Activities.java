package com.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.DateTimeException;
import java.util.Date;

@Builder
public class Activities {
    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("dueDate")
    private String dueDate;

    @JsonProperty("completed")
    private boolean completed;
}

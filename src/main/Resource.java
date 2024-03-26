package main;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Builder
@Jacksonized
public class Resource {
    private int id;

    private String name;

    private int year;

    private  String color;

    @JsonProperty(value = "pantone_value")
    private String pantoneValue;

}

package org.ontologyengineering.alflelolela;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    private Float temperature;

    @JsonCreator
    public Temperature(@JsonProperty(value="temperature") Float temperature) {
        this.temperature = temperature;
    }

    public Float getTemperature() {
        return temperature;
    }
}

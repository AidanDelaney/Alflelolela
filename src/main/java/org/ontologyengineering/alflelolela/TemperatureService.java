package org.ontologyengineering.alflelolela;

import java.util.Optional;

public class TemperatureService {
    private Optional<Temperature> temperature;

    public TemperatureService() {
        temperature = Optional.empty();
    }

    public Temperature setTemperature(Float temperature) {
        this.temperature = Optional.of(new Temperature(temperature));
        return getTemperature();
    }

    public Temperature getTemperature() {
        if(this.temperature.isPresent())
            return this.temperature.get();
        else
            return null;
    }
}

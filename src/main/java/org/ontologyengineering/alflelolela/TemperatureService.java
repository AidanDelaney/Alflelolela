package org.ontologyengineering.alflelolela;

import javax.ejb.Singleton;
import java.util.Optional;

@Singleton
public class TemperatureService {
    private Optional<Temperature> temperature;

    public TemperatureService() {
        temperature = Optional.empty();
    }

    public synchronized Optional<Temperature> setTemperature(Float temperature) {
        this.temperature = Optional.of(new Temperature(temperature));
        return getTemperature();
    }

    public Optional<Temperature> getTemperature() {
        return this.temperature;
    }
}

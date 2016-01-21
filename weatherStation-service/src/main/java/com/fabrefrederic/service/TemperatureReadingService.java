package com.fabrefrederic.service;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.dto.TemperatureReadingDto;

public interface TemperatureReadingService {

    /**
     * Get the latest temperature reading
     *
     * @return the latest temperature reading
     */
    TemperatureReading getTheLastTemperatureReading();

    /**
     * Save a new temperature reading
     *
     * @param temperatureReadingDto the temperature reading to save
     */
    void saveTemperatureReading(final TemperatureReadingDto temperatureReadingDto);

}

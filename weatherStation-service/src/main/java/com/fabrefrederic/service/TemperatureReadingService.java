package com.fabrefrederic.service;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.exception.SensorIsNotProvidedException;
import com.fabrefrederic.business.exception.SensorNotFoundException;

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
     * @param temperatureReading the temperature reading to save
     * @param sensorId sensor id
     * @throws SensorNotFoundException if the sensor is not found in the database
     * @throws SensorIsNotProvidedException if the sensor is not provided
     */
    void saveTemperatureReading(final TemperatureReading temperatureReading, final Integer sensorId)
            throws SensorNotFoundException, SensorIsNotProvidedException;

}

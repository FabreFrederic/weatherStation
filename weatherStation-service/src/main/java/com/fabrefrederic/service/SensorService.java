package com.fabrefrederic.service;

import com.fabrefrederic.business.Sensor;
import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.exception.SensorIsNotProvidedException;
import com.fabrefrederic.business.exception.SensorNotFoundException;

public interface SensorService {

    /**
     * Get the sensor by its id
     *
     * @param id id of the sensor
     * @return the sensor
     */
   Sensor getSensorById(final Integer id);

}

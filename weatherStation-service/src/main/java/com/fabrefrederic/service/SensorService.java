package com.fabrefrederic.service;

import com.fabrefrederic.business.Sensor;

public interface SensorService {

    /**
     * Get the sensor by its id
     *
     * @param id id of the sensor
     * @return the sensor
     */
   Sensor getSensorById(final Integer id);

}

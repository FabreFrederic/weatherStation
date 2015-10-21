package com.fabrefrederic.service;

import com.fabrefrederic.business.TemperatureReading;

public interface TemperatureReadingService {

    /**
     * Get the latest temperature reading
     *
     * @return the latest temperature reading
     */
    TemperatureReading getTheLastTemperatureReading();

}

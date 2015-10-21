package com.fabrefrederic.dao;

import javax.persistence.NoResultException;

import com.fabrefrederic.business.TemperatureReading;

public interface TemperatureReadingDao {

    /**
     * Get the latest temperature reading
     *
     * @return the latest temperature reading
     * @throws NoResultException
     */
    TemperatureReading getTheLastTemperatureReading() throws NoResultException;

}

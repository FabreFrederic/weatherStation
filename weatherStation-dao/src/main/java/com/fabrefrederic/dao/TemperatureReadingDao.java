package com.fabrefrederic.dao;

import com.fabrefrederic.business.TemperatureReading;

import javax.persistence.NoResultException;

public interface TemperatureReadingDao extends GenericDao<TemperatureReading> {

    /**
     * Get the latest temperature reading
     *
     * @return the latest temperature reading
     * @throws NoResultException
     */
    TemperatureReading getTheLastTemperatureReading() throws NoResultException;

}

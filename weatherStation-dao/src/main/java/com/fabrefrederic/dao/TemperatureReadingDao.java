package com.fabrefrederic.dao;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.dto.TemperatureReadingDto;

import javax.persistence.NoResultException;
import java.util.Date;
import java.util.List;

public interface TemperatureReadingDao extends GenericDao<TemperatureReading> {

    /**
     * Get the latest temperature reading
     *
     * @return the latest temperature reading
     * @throws NoResultException
     */
    TemperatureReading getTheLastTemperatureReading() throws NoResultException;

    /**
     * Get the temperature reading of the passed date
     *
     * @return a list of temperature reading
     * @throws NoResultException
     */
    List<TemperatureReading> getTemperatureReadingByDay(final Date date) throws NoResultException;
}

package com.fabrefrederic.service.impl;

import com.fabrefrederic.business.dto.TemperatureReadingDto;
import com.fabrefrederic.service.TemperatureReadingService;
import org.springframework.beans.factory.annotation.Autowired;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.dao.TemperatureReadingDao;
import org.springframework.stereotype.Service;

@Service
public class TemperatureReadingServiceImpl implements TemperatureReadingService {
    @Autowired
    private TemperatureReadingDao temperatureReadingDao;

    @Override
    public TemperatureReading getTheLastTemperatureReading() {
        return temperatureReadingDao.getTheLastTemperatureReading();
    }

    /**
     * @return the temperatureReadingDao
     */
    public TemperatureReadingDao getTemperatureReadingDao() {
        return temperatureReadingDao;
    }

    /**
     * @param temperatureReadingDao the temperatureReadingDao to set
     */
    public void setTemperatureReadingDao(TemperatureReadingDao temperatureReadingDao) {
        this.temperatureReadingDao = temperatureReadingDao;
    }

    @Override
    public void saveTemperatureReading(TemperatureReadingDto temperatureReadingDto) {

    }
}

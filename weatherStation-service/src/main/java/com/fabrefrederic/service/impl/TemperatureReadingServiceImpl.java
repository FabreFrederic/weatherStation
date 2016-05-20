package com.fabrefrederic.service.impl;

import com.fabrefrederic.business.Sensor;
import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.exception.SensorIsNotProvidedException;
import com.fabrefrederic.business.exception.SensorNotFoundException;
import com.fabrefrederic.dao.SensorDao;
import com.fabrefrederic.dao.TemperatureReadingDao;
import com.fabrefrederic.service.TemperatureReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class TemperatureReadingServiceImpl implements TemperatureReadingService {
    @Autowired
    private TemperatureReadingDao temperatureReadingDao;
    @Autowired
    private SensorDao sensorDao;

    @Override
    @Cacheable(value="lastTemperatureReadingCache")
    public TemperatureReading getTheLastTemperatureReading() {
        return temperatureReadingDao.getTheLastTemperatureReading();
    }

    @Override
    //@Cacheable(value="temperatureReadingByDayCache", key="#date")
    @Cacheable(value="temperatureReadingByDayCache")
    public List<TemperatureReading> getTemperatureReadingByDay(Date date) {
        return temperatureReadingDao.getTemperatureReadingByDay(date);
    }

    @Override
    @Transactional(rollbackFor={SensorNotFoundException.class, SensorIsNotProvidedException.class})
    public void saveTemperatureReading(final TemperatureReading temperatureReading, final Integer sensorId)
            throws SensorNotFoundException, SensorIsNotProvidedException {
        if (temperatureReading != null) {
            if (sensorId == null) {
                throw new SensorIsNotProvidedException("To save a new temperature reading the sensor must be provided");
            }
            Sensor sensor = sensorDao.findById(sensorId);
            if (sensor == null || sensor.getId() == 0) {
                throw new SensorNotFoundException("The sensor " + sensorId + " has not been found");
            }

            temperatureReading.setSensor(sensor);
            temperatureReadingDao.save(temperatureReading);
        }
    }

    public void setTemperatureReadingDao(TemperatureReadingDao temperatureReadingDao) {
        this.temperatureReadingDao = temperatureReadingDao;
    }

    public void setSensorDao(SensorDao sensorDao) {
        this.sensorDao = sensorDao;
    }
}

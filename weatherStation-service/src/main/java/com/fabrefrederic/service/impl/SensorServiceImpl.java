package com.fabrefrederic.service.impl;

import com.fabrefrederic.business.Sensor;
import com.fabrefrederic.dao.SensorDao;
import com.fabrefrederic.service.SensorService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class SensorServiceImpl implements SensorService {
    private static final Logger LOGGER = Logger.getLogger(SensorServiceImpl.class);

    @Autowired
    private SensorDao sensorDao;

    @Override
    public Sensor getSensorById(final Integer id) {
        return sensorDao.findById(id);
    }
}

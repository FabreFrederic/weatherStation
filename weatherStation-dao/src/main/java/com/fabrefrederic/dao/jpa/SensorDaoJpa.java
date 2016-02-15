package com.fabrefrederic.dao.jpa;

import com.fabrefrederic.business.Sensor;
import com.fabrefrederic.dao.SensorDao;
import org.springframework.stereotype.Component;

@Component("sensorDaoJpa")
public class SensorDaoJpa extends DaoJpa<Sensor> implements SensorDao {

}

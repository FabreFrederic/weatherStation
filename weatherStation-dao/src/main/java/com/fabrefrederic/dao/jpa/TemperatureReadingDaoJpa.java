package com.fabrefrederic.dao.jpa;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.TemperatureReading_;
import com.fabrefrederic.dao.TemperatureReadingDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Component("temperatureReadingDaoJpa")
public class TemperatureReadingDaoJpa extends DaoJpa<TemperatureReading> implements TemperatureReadingDao {
    private static final Logger LOGGER = Logger.getLogger(TemperatureReadingDaoJpa.class);
    private static final long serialVersionUID = 1L;

    @Override
    public TemperatureReading getTheLastTemperatureReading() throws NoResultException {
        TemperatureReading temperatureReading = null;

        try {
            final StringBuilder queryString = new StringBuilder();
            // queryString.append("select ");
            // queryString.append(TemperatureReading.class.getSimpleName());
            queryString.append(" from ");
            queryString.append(TemperatureReading.class.getSimpleName());
            queryString.append(" where ");
            queryString.append(TemperatureReading_.date.getName());
            queryString.append(" = (select max(");
            queryString.append(TemperatureReading_.date.getName());
            queryString.append(") from ");
            queryString.append(TemperatureReading.class.getSimpleName());
            queryString.append(")");

            final TypedQuery<TemperatureReading> query = entityManager.createQuery(queryString.toString(),
                    TemperatureReading.class);
            temperatureReading = query.getSingleResult();
        } catch (final Exception exception) {
            LOGGER.error(exception);
            throw exception;
        }

        if (LOGGER.isDebugEnabled()) {
            if (temperatureReading != null) {
                LOGGER.debug("A temperature reading has been found");
            } else {
                LOGGER.debug("No temperature reading found");
            }
        }

        return temperatureReading;
    }
}

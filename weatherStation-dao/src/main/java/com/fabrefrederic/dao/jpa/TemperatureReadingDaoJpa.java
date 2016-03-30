package com.fabrefrederic.dao.jpa;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.TemperatureReading_;
import com.fabrefrederic.dao.TemperatureReadingDao;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component("temperatureReadingDaoJpa")
public class TemperatureReadingDaoJpa extends DaoJpa<TemperatureReading> implements TemperatureReadingDao {
    private static final Logger LOGGER = Logger.getLogger(TemperatureReadingDaoJpa.class);
    private static final long serialVersionUID = 1L;
    private static final java.lang.String DATE_FORMAT = "yyyy/MM/dd";

    @Override
    public TemperatureReading getTheLastTemperatureReading() throws NoResultException {
        TemperatureReading temperatureReading = null;

        try {
            final StringBuilder queryString = new StringBuilder();
            queryString.append(" from ");
            queryString.append(TemperatureReading.class.getSimpleName());
            queryString.append(" where ");
            queryString.append(TemperatureReading_.date.getName());
            queryString.append(" = (select max(");
            queryString.append(TemperatureReading_.date.getName());
            queryString.append(") from ");
            queryString.append(TemperatureReading.class.getSimpleName());
            queryString.append(")");
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Query : " + queryString.toString());
            }

            final TypedQuery<TemperatureReading> query = entityManager.createQuery(queryString.toString(),
                    TemperatureReading.class);
            temperatureReading = query.getSingleResult();
        } catch (final Exception exception) {
            LOGGER.error(exception);
            throw exception;
        }

        if (LOGGER.isDebugEnabled()) {
            if (temperatureReading != null) {
                LOGGER.debug("A temperature reading has been found - id : " + temperatureReading.getId());
            } else {
                LOGGER.debug("No temperature reading found");
            }
        }

        return temperatureReading;
    }

    @Override
    public List<TemperatureReading> getTemperatureReadingByDay(final Date date) throws NoResultException {
        List<TemperatureReading> temperatureReadings = new ArrayList<>();
        Date beginDate = DateUtils.truncate(date, java.util.Calendar.DAY_OF_MONTH);
        Date endDate = DateUtils.addDays(date, 1);

        try {
            final StringBuilder queryString = new StringBuilder();
            queryString.append(" from ");
            queryString.append(TemperatureReading.class.getSimpleName());
            queryString.append(" where ");
            queryString.append(TemperatureReading_.date.getName());
            queryString.append(" ");
            queryString.append("BETWEEN ");
            queryString.append(":beginDate ");
            queryString.append("AND ");
            queryString.append(":endDate ");
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Query : " + queryString.toString());
            }

            final TypedQuery<TemperatureReading> query = entityManager.createQuery(queryString.toString(),
                    TemperatureReading.class);
            query.setParameter("beginDate", beginDate);
            query.setParameter("endDate", endDate);
            temperatureReadings = query.getResultList();
        } catch (final Exception exception) {
            LOGGER.error(exception);
            throw exception;
        }

        if (LOGGER.isDebugEnabled()) {
            if (temperatureReadings != null) {
                LOGGER.debug("A temperature reading list has been found - size : " + temperatureReadings.size());
            } else {
                LOGGER.debug("No temperature reading found");
            }
        }

        return temperatureReadings;
    }
}

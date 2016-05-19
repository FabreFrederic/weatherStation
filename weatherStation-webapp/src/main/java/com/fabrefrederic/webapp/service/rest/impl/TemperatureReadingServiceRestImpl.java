package com.fabrefrederic.webapp.service.rest.impl;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.dto.TemperatureReadingDto;
import com.fabrefrederic.business.exception.SensorIsNotProvidedException;
import com.fabrefrederic.business.exception.SensorNotFoundException;
import com.fabrefrederic.service.TemperatureReadingService;
import com.fabrefrederic.webapp.service.rest.TemperatureReadingServiceRest;
import org.apache.log4j.Logger;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLEngineResult;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class TemperatureReadingServiceRestImpl implements TemperatureReadingServiceRest {
    private static final Logger LOGGER = Logger.getLogger(TemperatureReadingServiceRestImpl.class);
    private static final String DATE_FORMAT = "yyyyMMdd";

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper dozerBeanMapper;

    @Autowired
    @Qualifier("temperatureReadingService")
    private TemperatureReadingService temperatureReadingService;

    public TemperatureReadingServiceRestImpl() {
    }

    @Override
    public TemperatureReadingDto getTheLastTemperatureReading() {
        TemperatureReading temperatureReading = temperatureReadingService.getTheLastTemperatureReading();
        TemperatureReadingDto lastTemperatureReadingDto = null;
        try {
            lastTemperatureReadingDto = dozerBeanMapper.map(temperatureReading, TemperatureReadingDto.class);
        } catch (final MappingException mappingException) {
            LOGGER.error("Error while mapping", mappingException);
            throw new WebApplicationException(mappingException, Response.Status.INTERNAL_SERVER_ERROR);
        }
        return lastTemperatureReadingDto;
    }

    @Override
    public List<TemperatureReadingDto> getTemperatureReadingByDay(final String dateString) {
        final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date date = null;
        try {
            date = dateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
        List<TemperatureReading> temperatureReadings = temperatureReadingService.getTemperatureReadingByDay(date);
        List<TemperatureReadingDto> temperatureReadingDtos = new ArrayList<>();
        TemperatureReadingDto newTemperatureReadingDto = null;

        for (TemperatureReading temperatureReading : temperatureReadings) {
            try {
                newTemperatureReadingDto = dozerBeanMapper.map(temperatureReading, TemperatureReadingDto.class);
            } catch (final MappingException mappingException) {
                LOGGER.error("Error while mapping", mappingException);
                throw new WebApplicationException(mappingException, Response.Status.INTERNAL_SERVER_ERROR);
            }
            if (newTemperatureReadingDto != null) {
                temperatureReadingDtos.add(newTemperatureReadingDto);
            }
        }
        return temperatureReadingDtos;
    }


    @Override
    public Response saveTemperatureReading(final TemperatureReadingDto temperatureReadingDto) throws WebApplicationException {
        TemperatureReading temperatureReading = null;

        try {
            temperatureReading = dozerBeanMapper.map(temperatureReadingDto, TemperatureReading.class);
        } catch (final MappingException mappingException) {
            LOGGER.debug("Bad request exception", mappingException);
            throw new WebApplicationException(mappingException, Response.Status.BAD_REQUEST);
        }

        try {
            if (temperatureReading != null) {
                temperatureReadingService.saveTemperatureReading(temperatureReading, temperatureReadingDto.getSensorId());
            }
        } catch(SensorIsNotProvidedException sensorIsNotProvidedException) {
            LOGGER.debug(sensorIsNotProvidedException);
            throw new WebApplicationException(sensorIsNotProvidedException,
                    Response.Status.BAD_REQUEST);
        } catch(SensorNotFoundException sensorNotFoundException) {
            LOGGER.debug(sensorNotFoundException);
            throw new WebApplicationException(sensorNotFoundException,
                    Response.Status.BAD_REQUEST);
        } catch(Exception exception) {
            LOGGER.error("Error while saving a new temperature reading", exception);
            throw new WebApplicationException("Error while saving a new temperature reading",
                    Response.Status.INTERNAL_SERVER_ERROR);
        }

        return Response.status(200).build();
    }

    @Override
    public Response printMessage(@PathParam("param") String msg) {
        String result = "Restful Return! : " + msg;
        return Response.status(200).entity(result).build();
    }

    public void setDozerBeanMapper(Mapper dozerBeanMapper) {
        this.dozerBeanMapper = dozerBeanMapper;
    }

    public void setTemperatureReadingService(TemperatureReadingService temperatureReadingService) {
        this.temperatureReadingService = temperatureReadingService;
    }
}
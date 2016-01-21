package com.fabrefrederic.webapp.service.rest.impl;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.business.dto.TemperatureReadingDto;
import com.fabrefrederic.service.TemperatureReadingService;
import com.fabrefrederic.webapp.service.rest.TemperatureReadingServiceRest;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Component
public class TemperatureReadingServiceRestImpl implements TemperatureReadingServiceRest {

    @Autowired
    @Qualifier("dozerBeanMapper")
    private Mapper dozerBeanMapper;

    @Autowired
    @Qualifier("temperatureReadingService")
    private TemperatureReadingService temperatureReadingService;

    @Override
    public TemperatureReadingDto getTheLastTemperatureReading() {
        TemperatureReading temperatureReading = temperatureReadingService.getTheLastTemperatureReading();
        final TemperatureReadingDto temperatureReadingDto = dozerBeanMapper.map(temperatureReading,
            TemperatureReadingDto.class);

        return temperatureReadingDto;
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

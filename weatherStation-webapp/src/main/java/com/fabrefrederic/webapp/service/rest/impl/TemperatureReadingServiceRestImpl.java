package com.fabrefrederic.webapp.service.rest.impl;

import com.fabrefrederic.webapp.service.rest.TemperatureReadingServiceRest;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

public class TemperatureReadingServiceRestImpl implements TemperatureReadingServiceRest {

//    @Autowired
//    private Mapper dozerBeanMapper;
//    @Autowired
//    private TemperatureReadingService temperatureReadingService;
//
//    public TemperatureReadingDto getTheLastTemperatureReading() {
//        TemperatureReading temperatureReading = temperatureReadingService.getTheLastTemperatureReading();
//        final TemperatureReadingDto temperatureReadingDto = dozerBeanMapper.map(temperatureReading,
//            TemperatureReadingDto.class);
//
//        return temperatureReadingDto;
//    }

    public Response printMessage(@PathParam("param") String msg) {
        String result = "Restful Return! : " + msg;
        return Response.status(200).entity(result).build();
    }
}

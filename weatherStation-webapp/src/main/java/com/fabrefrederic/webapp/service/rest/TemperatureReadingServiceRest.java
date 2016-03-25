package com.fabrefrederic.webapp.service.rest;

import com.fabrefrederic.business.dto.TemperatureReadingDto;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/temperatureReading")
public interface TemperatureReadingServiceRest {

    @GET
    @Path("/getTheLastTemperatureReading")
    @Produces("application/json")
    TemperatureReadingDto getTheLastTemperatureReading();

    @POST
    @Path("/saveTemperatureReading")
    @Consumes("application/json")
    Response saveTemperatureReading(final TemperatureReadingDto temperatureReading) throws WebApplicationException;

    @GET
    @Path("/printmessage/{param}")
    Response printMessage(@PathParam("param") String msg);
}
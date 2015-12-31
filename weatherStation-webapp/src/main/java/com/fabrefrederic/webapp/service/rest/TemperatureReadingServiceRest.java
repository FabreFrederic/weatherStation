package com.fabrefrederic.webapp.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/temperatureReading")
public interface TemperatureReadingServiceRest {

//    @GET
//    @Path("/getTheLastTemperatureReading")
//    @Produces("application/xml")
//    TemperatureReadingDto getTheLastTemperatureReading();

    @GET
    @Path("/printmessage/{param}")
    public Response printMessage(@PathParam("param") String msg);
}

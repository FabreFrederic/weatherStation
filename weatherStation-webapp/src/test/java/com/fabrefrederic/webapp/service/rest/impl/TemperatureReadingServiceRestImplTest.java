package com.fabrefrederic.webapp.service.rest.impl;

import com.fabrefrederic.business.dto.TemperatureReadingDto;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

@RunWith(MockitoJUnitRunner.class)
public class TemperatureReadingServiceRestImplTest {

    @Test
    public void testSaveTemperatureReading() {
        try {
            TemperatureReadingDto temperatureReadingDto = new TemperatureReadingDto();
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target =
                    client.target("http://localhost:8081/weatherStation-webapp/rest/temperatureReading/saveTemperatureReading");
            Response response = target.request().post(Entity.entity(temperatureReadingDto, "application/xml"));

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }
            System.out.println("Server response : \n");
            System.out.println(response.readEntity(String.class));
            response.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
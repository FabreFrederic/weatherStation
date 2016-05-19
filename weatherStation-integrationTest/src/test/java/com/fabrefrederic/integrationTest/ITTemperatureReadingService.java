/**
 *
 */
package com.fabrefrederic.integrationTest;

import com.fabrefrederic.business.TemperatureReading;
import com.fabrefrederic.service.TemperatureReadingService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/com/fabrefrederic/service/spring/applicationContext-service.xml",
        "classpath:/com/fabrefrederic/integrationTest/spring/applicationContext-dao-datasource.xml",
"classpath:/com/fabrefrederic/integrationTest/spring/applicationContext-dao-model.xml" })
public class ITTemperatureReadingService {

    @Autowired
    private TemperatureReadingService temperatureReadingService;

    @Test
    @Transactional
    public void getTheLastTemperatureReading() {
        // when
        final TemperatureReading temperatureReading = temperatureReadingService.getTheLastTemperatureReading();

        // then
        Assert.assertNotNull(temperatureReading);
        Assert.assertNotNull(temperatureReading.getTemperature());
    }

    @Test
    @Transactional
    public void getTemperatureReadingByDay() {
        // given
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String dateInString = "2015/10/20";

        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            Assert.fail(e.getMessage());
        }

        // when
        final List<TemperatureReading> temperatureReadings = temperatureReadingService.getTemperatureReadingByDay(date);

        // then
        Assert.assertNotNull(temperatureReadings);
        Assert.assertTrue(temperatureReadings.size() > 0);
        Assert.assertEquals(1, temperatureReadings.size());
    }
}

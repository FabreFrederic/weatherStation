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
        // given
        // final int numberOfCommits = 5;

        // when
        final TemperatureReading temperatureReading = temperatureReadingService.getTheLastTemperatureReading();

        // then
        Assert.assertNotNull(temperatureReading);
        Assert.assertNotNull(temperatureReading.getTemperature());
    }

}

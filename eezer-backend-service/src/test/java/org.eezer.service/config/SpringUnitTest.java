package org.eezer.service.config;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles({ "test", "unit" })
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { UnitTestServiceConfig.class, ServiceConfig.class })
public abstract class SpringUnitTest {

    @Autowired
    private MongoTemplate mongoTemplate;

}

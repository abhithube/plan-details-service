package io.abhithube.plandetailsservice;

import io.abhithube.plandetailsservice.config.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


@SpringBootTest
@ContextConfiguration(classes = TestConfig.class)
class PlanDetailsServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}

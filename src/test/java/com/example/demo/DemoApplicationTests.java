package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("local")
// @PropertySource or @TestPropertySource("classpath:properties.yml")
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}

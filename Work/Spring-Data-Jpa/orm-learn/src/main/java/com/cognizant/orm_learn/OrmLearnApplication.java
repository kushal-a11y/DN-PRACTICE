package com.cognizant.orm_learn;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrmLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main.");
	}

}

package com.irctc.rail.connect;

import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.Logger;

@SpringBootApplication
public class IrctcRailApplication {

	private static final Logger LOGGER=LogManager.getLogger(IrctcRailApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(IrctcRailApplication.class, args);
		
		LOGGER.info("INFO LOGS");
		LOGGER.error("ERROR LOGS");
		LOGGER.warn("WARNING LOGS");
		LOGGER.debug("DEBUG LOGS");
	}

}


//next implementation

//logging
//exception handling
//pagination
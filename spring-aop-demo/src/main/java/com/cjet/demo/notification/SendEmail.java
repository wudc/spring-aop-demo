package com.cjet.demo.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.cjet.demo.usecase.Notification;

@Component
public class SendEmail implements Notification {
	private static final Logger LOGGER = LogManager.getLogger(SendEmail.class);

	@Override
	public void sendGeneralNotification() {
		LOGGER.info("Genearl Email is sent.");
		
	}

	@Override
	public void sendSQLExceptionNotification() {
		LOGGER.info("SQLException Email is sent.");
	}
	
	@Override
	public void sendJSonExceptionNotification() {
		LOGGER.info("MyJSonException Email is sent.");
	}

}

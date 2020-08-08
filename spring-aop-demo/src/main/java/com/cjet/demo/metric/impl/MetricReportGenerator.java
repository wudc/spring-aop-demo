package com.cjet.demo.metric.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjet.demo.notification.SendEmail;
import com.cjet.demo.usecase.MetricReport;

@Service
public class MetricReportGenerator implements MetricReport {
	private static final Logger LOGGER = LogManager.getLogger(MetricReportGenerator.class);

	@Autowired
	private TotalCountsAspect totalCountsAspect;
	
	@Autowired
	private ExceptionAspect exceptionAspect;
	
	@Autowired
	private SendEmail sendEmailService;
	
	@Override
	public void generateMetricReport() {
		// TODO Auto-generated method stub
		LOGGER.info("Summary total Json error: " + totalCountsAspect.getJSonError());
	}

	@Override
	public void generateNotification() {
		if (exceptionAspect.isJsonError()) {
			sendEmailService.sendJSonExceptionNotification();
		}
		
		exceptionAspect.resetFlags();
	}

}

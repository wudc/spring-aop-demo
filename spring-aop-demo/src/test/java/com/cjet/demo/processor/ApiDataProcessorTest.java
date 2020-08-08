package com.cjet.demo.processor;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjet.demo.exception.MyJSonException;
import com.cjet.demo.metric.impl.MetricReportGenerator;
import com.cjet.demo.service.ApiService;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiDataProcessorTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ApiDataProcessor dataProcessor;

	@Autowired
	private ApiService service;
	
	@Autowired
	private MetricReportGenerator report;

	@Test
	void testDataProcessor() throws InterruptedException {
		dataProcessor.process();
		dataProcessor.getJsonErrorCount();
	}

	@Test
	void testService() {
		try {
			service.throwJsonException();
		} catch (MyJSonException ex) {
			logger.info("Handler this exception.");
		}
	}

	@Test
	void testMetricReport() throws InterruptedException {
		dataProcessor.process();
		try {
			service.throwJsonException();
		} catch (MyJSonException ex) {
			logger.info("Handler this exception.");
		}
		report.generateMetricReport();
		report.generateNotification();
	}

}

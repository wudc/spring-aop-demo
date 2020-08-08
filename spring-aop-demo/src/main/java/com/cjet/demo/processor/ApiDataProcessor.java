package com.cjet.demo.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cjet.demo.metric.TrackProcessTime;

@Service
public class ApiDataProcessor {
	
	private int jsonErrorCount;
	private int sqlErrorCount;
	private int generalErrorCount;
	private List<String> features = new ArrayList<>();
	
	@TrackProcessTime
	public void process() throws InterruptedException {
		System.out.println("ApiDataProcessor start processing data.");
		for (int i=0; i< 5; i++) {
			addJsonErrorCount();
			addSqlErrorCount();
			addGeneralErrorCount();
			features.add("Feature" + i);
			Thread.sleep(2000);
		}
	}
	
	public void sumUpData() {
		System.out.println("Totaling the metric.");
	}
	
	private void addJsonErrorCount() {
		jsonErrorCount++;
	}
	
	private void addSqlErrorCount() {
		sqlErrorCount++;
	}

	private void addGeneralErrorCount() {
		generalErrorCount++;
	}

	public int getJsonErrorCount() {
		return jsonErrorCount;
	}

	public int getSqlErrorCount() {
		return sqlErrorCount;
	}

	public int getGeneralErrorCount() {
		return generalErrorCount;
	}
	
	public int getFeaturesSize() {
		return features.size();
	}
}

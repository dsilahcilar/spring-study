package com.turbine.configuration;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.turbine.model.State;
import com.turbine.model.Turbine;
import com.turbine.service.TurbineService;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {
	@Autowired
	private TurbineService turbineService;
	
	//TODO configurationdan alınabilir mi?
	@Scheduled(fixedDelay = 1000)
	public void checkTurbineService() {
		System.out.println("work...");
		Map<String, Turbine> turbineMap = turbineService.getTurbineMap();
		Collection<Turbine> turbines = turbineMap.values();
		for (Turbine turbine : turbines) {
			turbine.generatePower();
		}
	}
}

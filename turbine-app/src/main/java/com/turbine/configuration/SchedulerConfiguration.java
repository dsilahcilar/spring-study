package com.turbine.configuration;

import com.turbine.model.Turbine;
import com.turbine.service.TurbineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collection;
import java.util.Map;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {
    @Autowired
    private TurbineService turbineService;

    @Scheduled(fixedDelayString = "${rev.scheduler.delay}")
    public void checkTurbineService() {
        Map<String, Turbine> turbineMap = turbineService.getTurbineMap();
        Collection<Turbine> turbines = turbineMap.values();
        for (Turbine turbine : turbines) {
            turbineService.generatePower(turbine);
        }
    }
}

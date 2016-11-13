package com.rev;

import javax.sql.DataSource;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfiguration {
	   
	@Profile("cloud")	    
   @Bean
    public DataSource dataSource() {
        CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        String serviceID = cloud.getServiceInfos().get(0).getId();
        System.out.println("service Id " + serviceID);
        return cloud.getServiceConnector(serviceID, DataSource.class, null);
    }


	  
	    
}

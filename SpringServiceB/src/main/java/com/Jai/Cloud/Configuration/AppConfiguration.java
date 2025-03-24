package com.Jai.Cloud.Configuration;

import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
	
	@Bean
	 RestTemplate rt() {
		return new RestTemplate();
		
	}
	

}

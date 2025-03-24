package com.Jai.Cloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("v1/api/A")
public class ProcessARestController {
	
	@Autowired
	private RestTemplate rt;

	
	@GetMapping("/showA")
	public String ShowMsg() {
		String Response = rt.getForEntity("http://localhost:8082/v1/api/B/showB", String.class).getBody();
		
	   return "From A :"+ Response;
	}
	
}

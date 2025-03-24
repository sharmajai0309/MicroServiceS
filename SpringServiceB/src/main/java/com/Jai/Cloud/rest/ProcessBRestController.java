package com.Jai.Cloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("v1/api/B")
public class ProcessBRestController {
	
	@Autowired
	private RestTemplate rt;

	
	@GetMapping("/showB")
	public String ShowMsg() {
	String Response = rt.getForEntity("http://localhost:8083/v1/api/C/showC", String.class).getBody();
		
	   return "From B.."+Response;
	}
	
}

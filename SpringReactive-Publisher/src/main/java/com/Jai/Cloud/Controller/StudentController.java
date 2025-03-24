package com.Jai.Cloud.Controller;

import java.security.Provider.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Jai.Cloud.Entity.Student;
import com.Jai.Cloud.Service.IStudentService;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/v1/api/Student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
   
	/*
	 * Create Document
	 * Method : ResponseEntity<Student>
	 * Path   : /create
	 * Input  : Student(@RequestBody)
	 * R.T    : Mono<Student>
	 */
	
	
	 @PostMapping(value = "/create", consumes = "application/json")
	public Mono<Student> save(@RequestBody Student student){
		
		
		return service.SaveStudent(student)	;
	}
	
//	public Mono<Student> 
	
	
	
	
	
	
	
	
}

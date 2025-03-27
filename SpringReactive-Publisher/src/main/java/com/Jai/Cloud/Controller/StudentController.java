package com.Jai.Cloud.Controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Jai.Cloud.Entity.Student;
import com.Jai.Cloud.Service.IStudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/v1/api/Student")
public class StudentController {
	
	@Autowired
	private IStudentService service;
	
	@PostMapping(value = "/create", consumes = "application/json")
	public Mono<Student> save(@RequestBody Student student) {
		return service.SaveStudent(student);
	}
	 
	@GetMapping(value = "/find/{id}")
	public Mono<Student> findStudent(@PathVariable String id) {
		return service.getOneStudentInfo(id);
	}
	
	@GetMapping(value = "/find")
	public Flux<Student> findAllStudents() {
		return service.findAllStudent();
	}
	
	// Updated Endpoint to prevent conflict
	@GetMapping(value = "/findByName/{name}")
	public Flux<Student> findStudentByName(@PathVariable String name) {
		return service.findStudentByname(name);
	}
	
	@DeleteMapping("/delete/{id}")
	public Mono<Void> DeleteStudent(@PathVariable String id) {
		return service.deleteStudent(id);
	}
	
	@DeleteMapping("/deleteByName/{name}")
	public Mono<Void> DeleteStudentByName(@RequestParam String name) {
		return service.deleteByName(name);
		
	}
	
	
	
}

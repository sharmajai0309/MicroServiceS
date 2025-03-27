package com.Jai.Cloud.Service;

import com.Jai.Cloud.Entity.Student;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IStudentService { 
	
	
	public Mono<Student> SaveStudent(Student student);
	public Mono<Student> getOneStudentInfo(String id);
	public Flux<Student> findAllStudent();
	public Mono<Void> deleteStudent(String id);
	public Flux<Student> findStudentByname(String name);
	public Mono<Void> deleteByName(String name);
	
	
	
}

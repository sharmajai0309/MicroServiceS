package com.Jai.Cloud.Repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.Jai.Cloud.Entity.Student;

import reactor.core.publisher.Flux;

import java.util.List;



@Repository
public interface IStudentRepository extends ReactiveMongoRepository<Student,String> {
	
	@Query("{ 'name' : ?0 }")
	Flux<Student> findByName(String name);
}

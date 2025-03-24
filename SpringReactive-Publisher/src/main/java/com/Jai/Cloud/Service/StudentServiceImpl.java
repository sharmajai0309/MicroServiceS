package com.Jai.Cloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Jai.Cloud.Entity.Student;
import com.Jai.Cloud.Repository.IStudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private IStudentRepository repo;

	@Override
	public Mono<Student> SaveStudent(Student student) {
		
		Mono<Student> save = repo.save(student);
		System.out.println("Student Saved");
		return save;
		
	}

	@Override
	public Mono<Student> getOneStudentInfo(String id) {
		System.out.println("Student Called");
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}

	@Override
	public Flux<Student> findAllStudent() {
		System.out.println("Student List Called");
		Flux<Student> all = repo.findAll();
		
		return all;
	}

	@Override
	public Mono<Void> deleteStudent(String id) {
		System.out.println("Student Deleted");
		return repo.deleteById(id).switchIfEmpty(Mono.empty());
	}

}

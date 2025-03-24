package com.Jai.Cloud.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.Jai.Cloud.Entity.Student;


@Repository
public interface IStudentRepository extends ReactiveMongoRepository<Student,String> {

}

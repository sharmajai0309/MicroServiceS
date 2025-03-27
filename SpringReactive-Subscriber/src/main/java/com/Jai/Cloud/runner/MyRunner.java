package com.Jai.Cloud.runner;



import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.Jai.Cloud.Entity.Student;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MyRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		
//		create();
//		findall();
//		findStudent("32");
		deleteStudent("32");
		
		
		
	
	}
	public void create() {
		/*
		 *  Path  : /v1/api/Student/create 
		 *  Input : student
		 *  Output: Mono
		 *  status: 200
		 *
		 */
	 
		Student student = new Student("35", "JKS", 34.23);
		WebClient wc = WebClient.create("http://localhost:9999/v1/api/Student");
		Mono<Student> result = wc.post().uri("/create").body(Mono.just(student),Student.class).retrieve().bodyToMono(Student.class);
		result.subscribe(System.out::println);
		
	}
	
	public void findall() {
		
		/*
		 *  /v1/api/Student/find
		 * Input  :Student
		 * Output : FLUX
		 * Status : 200
		 */
		
		WebClient wc1 = WebClient.create("http://localhost:9999/v1/api/Student");
		 wc1.get()
				.uri("/find")
				.retrieve()
				.bodyToFlux(Student.class)
				.doOnNext(result -> System.out.println(result))
				.doOnError(error -> System.out.println("Error Occured"));
				
		       
		}
	
	
	
	public void findStudent(String studentId) {
	    WebClient wc2 = WebClient.create("http://localhost:9999/v1/api/Student");

	    Disposable subscribe = wc2.get()
	        .uri("/find/{id}", studentId)
	        .retrieve()
	        .bodyToMono(Student.class)
	        .doOnNext(student -> System.out.println("Received Student: " + student))
	        .doOnError(error -> System.err.println("Error fetching student: " + error.getMessage()))
	        .switchIfEmpty(Mono.defer(() -> {
	            System.out.println("No student found with ID: " + studentId);
	            return Mono.empty();
	        }))
	        .subscribe();
	    
	    System.out.println(subscribe);
	}
	
	
	public void deleteStudent(String id) {
	    WebClient wc3 = WebClient.create("http://localhost:9999/v1/api/Student");

	    wc3.delete()
	        .uri("/delete/{id}", id)
	        .retrieve()
	        .onStatus(status -> status.value() == 404, response -> Mono.error(new RuntimeException("Student not found: " + id))) // Handle 404 errors
	        .bodyToMono(Void.class)
	        .doOnSuccess(v -> System.out.println("Student deleted successfully: " + id)) // Corrected Logging
	        .doOnError(error -> System.err.println("Error: " + error.getMessage())) // Error handling
	        .subscribe();

	    System.out.println("Delete request sent for student: " + id);
	}


		
		
		
}



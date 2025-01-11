package in.jai.MQ;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringApacheAciveMQApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApacheAciveMQApplication.class, args);
		System.out.println("SpringApacheAciveMQApplication Main function started");
		
	}

}

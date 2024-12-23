package in.jai.Cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringcloudSchedulerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudSchedulerServiceApplication.class, args);
	}

}

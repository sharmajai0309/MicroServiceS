package in.jai.Cloud;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudCartServiceApplication.class, args);
	}

}

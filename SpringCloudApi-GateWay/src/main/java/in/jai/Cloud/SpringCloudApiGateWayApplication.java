package in.jai.Cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudApiGateWayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudApiGateWayApplication.class, args);
		System.out.println("Api GateWay Started");
		
	}

}

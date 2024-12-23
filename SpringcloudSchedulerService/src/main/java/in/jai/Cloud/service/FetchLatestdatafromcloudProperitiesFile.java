package in.jai.Cloud.service;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FetchLatestdatafromcloudProperitiesFile {
	@Scheduled(cron = "10 * * * * *")
	public void fetch() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>("{}",headers);
		
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:9991/actuator/refresh";
		String output = rt.postForEntity("http://localhost:9991/actuator/refresh",entity,String.class).getBody();
		System.out.println(output);
		System.out.println("Scheduler started");
		
	}
	

}

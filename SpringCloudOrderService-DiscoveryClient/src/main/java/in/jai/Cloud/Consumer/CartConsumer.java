package in.jai.Cloud.Consumer;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumer {
	
	@Autowired
	private DiscoveryClient client;
	
	//Logic to consume Other Services
	public String getCartServices() {
		// Getting All the Instances on Service Name
		List<ServiceInstance> list = client.getInstances("CART-SERVICE");
		
		// Getting the details of 0th index 
		ServiceInstance instance = list.get(0);
		
		// Based on the instance get the uri and create URL
		URI uri = instance.getUri();
		
		
		String url = uri + "/v1/api/cart/show";
		
		
		// PUT URL in rest template and shoot the request
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> RE = rt.getForEntity(url, String.class);
		
		return RE.getBody()+"my name is jai";
		
		
		 
	}

}

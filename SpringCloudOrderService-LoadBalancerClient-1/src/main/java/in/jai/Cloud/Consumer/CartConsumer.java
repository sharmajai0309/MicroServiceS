package in.jai.Cloud.Consumer;

import java.net.URI; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CartConsumer {
	
	@Autowired
	private LoadBalancerClient LB;
	
	//Logic to consume Other Services
	public String getCartServices() {

    // asking client to give the instance using it number with low load factor
		ServiceInstance SI = LB.choose("CART-SERVICE");
		
		URI uri = SI.getUri();
		String url = uri + "/v1/api/cart/show";
		
		
		// PUT URL in rest template and shoot the request
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> RE = rt.getForEntity(url, String.class);
		
		return RE.getBody()+"my name is jai";
		
		
		 
	}

}

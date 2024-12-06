package in.jai.Cloud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jai.Cloud.Consumer.CartConsumer;

@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {

	@Autowired
    private CartConsumer consumer;
	
	
	/*
	 * METHOD : GET
	 * PATH   : /place
	 * OUTPUT : R.T<String>
	 * URL    :/v1/api/order/place
	 */
 
	@GetMapping("/place")
	public ResponseEntity<String> placeorder(){
		String cartResponse = consumer.getCartServices();
		
		return ResponseEntity.ok("Order Placed With =>"+ cartResponse);
		
	}
}

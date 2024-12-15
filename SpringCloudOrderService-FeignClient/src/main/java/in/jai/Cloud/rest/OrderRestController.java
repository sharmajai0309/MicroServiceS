package in.jai.Cloud.rest;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import in.jai.Cloud.Consumer.ICartConsumer;
import in.jai.Cloud.Response.Cart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/v1/api/order")
public class OrderRestController {

	@Value("${server.port}")
	private String portNo;
	
	/*
	 * METHOD  : GET
	 * PATH    : /place
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/order/place
	 * 
	 */
	@Autowired
	private ICartConsumer consumer;
	
	@GetMapping("/place")
	public ResponseEntity<String> placeOrder() {
		String cartResponse = consumer.getCartInfo().getBody();
		return ResponseEntity.ok("ORDER PLACED WITH => "+cartResponse);
	}

	/*
	 * METHOD  : GET
	 * PATH    : /fetch
	 * OUTPUT  : R.E<String>
	 * URL     : http://localhost:7777/v1/api/order/fetch/{id}
	 * 
	 */
	@GetMapping("/fetch/{id}")
	public ResponseEntity<String> fetchOrderWithCart(@PathVariable Integer id) {
	    String cartResponse = consumer.getCartById(id).getBody();
	    String response = "PORT NO OF ORDER IS :: " + portNo + " ORDER WITH CART DATA => " + cartResponse;
	    return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<String> fetchList(@RequestBody Cart cart){
		String cartResponse = consumer.addToCartDetails(cart).getBody();
		return ResponseEntity.ok(cartResponse);
	}
	
	
	
	
	
	

	
	
	
}

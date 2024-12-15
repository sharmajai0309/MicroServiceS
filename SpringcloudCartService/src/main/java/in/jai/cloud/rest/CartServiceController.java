package in.jai.Cloud.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/api/cart")
@CrossOrigin(origins = "http://localhost:3000")
public class CartServiceController {
	
	@Value("${server.port}")
	private String portNo;
	
	
	/*
	 * METHOD  : GET
	 * PATH    : /show
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/cart/show
	 * 
	 * 
	 */
	
	@GetMapping("/show")
	 public ResponseEntity<String> getCartDetails() {
	        // Example string
	        String cartMessage = "Welcome to Cart Service!"+portNo;

	        return ResponseEntity.ok(cartMessage);
	    }
}

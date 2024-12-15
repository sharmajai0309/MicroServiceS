package in.jai.Cloud.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.jai.Cloud.response.Cart;


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
	 */
	
	@GetMapping("/show")
	 public ResponseEntity<String> getCartDetails() {
	        // Example string
	        String cartMessage = "Welcome to Cart Service!"+portNo;

	        return ResponseEntity.ok(cartMessage);
	    }
	
	
	/*
	 * METHOD : GET
	 * PATH   : /find{id}
	 * OUTPUT : R.T<cart>
	 * Input  : id (@pathVariable)
	 * URL    :/v1/api/cart/find/{id}
	 */
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Cart>getCartById(@PathVariable Integer id) {
		Cart cart = new Cart();
		cart.setCartId(id);
		cart.setCartCode(portNo);
		cart.setCartCost(23000.9);
		return ResponseEntity.ok(cart);
	}
	
	/*
	 * METHOD  : POST
	 * PATH    : /Create
	 * OUTPUT  : R.E<String>
	 * URL     : /v1/api/cart/create
	 */
	
	@PostMapping("/create")
	public ResponseEntity<String> addToCart(
			@RequestBody Cart cart) {
		return ResponseEntity.ok("Added to Cart" + cart + " " +portNo);
	}
	
	
	
	
}

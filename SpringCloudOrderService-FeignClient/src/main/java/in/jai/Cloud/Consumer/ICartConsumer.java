package in.jai.Cloud.Consumer;



import org.springframework.cloud.openfeign.FeignClient;  
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import in.jai.Cloud.Response.*;



@FeignClient(name = "CART-SERVICE")
public interface ICartConsumer {

	@GetMapping("/v1/api/cart/show")
	 public ResponseEntity<String> getCartInfo();
	
	
	 @GetMapping("/v1/api/cart/find/{id}")
	    ResponseEntity<String> getCartById(@PathVariable("id") Integer id);
	 
	 @PostMapping("/v1/api/cart/create")
		public ResponseEntity<String> addToCartDetails(
				@RequestBody Cart cart);
	
}

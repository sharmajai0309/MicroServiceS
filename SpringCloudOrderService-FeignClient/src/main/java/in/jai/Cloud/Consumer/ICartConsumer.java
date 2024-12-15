package in.jai.Cloud.Consumer;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient("CART-SERVICE")
public interface ICartConsumer {

	@GetMapping("/v1/api/cart/show")
	 public ResponseEntity<String> getCartInfo();
}

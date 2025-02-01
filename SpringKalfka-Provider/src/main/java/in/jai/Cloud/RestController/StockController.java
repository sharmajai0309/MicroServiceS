package in.jai.Cloud.RestController;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import in.jai.Cloud.Entity.Stock;
import in.jai.Cloud.converter.JsonToString;
import in.jai.Cloud.producer.ProducerService;

@RestController
@RequestMapping("/v1/api/stock")
public class StockController {
	
	@Autowired
	ProducerService service;
	
	@Autowired
    JsonToString converter;

	/*
	 * METHOD : GET
	 * INPUT  : Cost, Code (@RequestParam)
	 * OUTPUT : String (Success or Failure)
	 * PATH   : /v1/api/stock/send
	 */
	@GetMapping("/send")
	public String sendStockMessage(@RequestParam Double cost, @RequestParam String code) throws JsonProcessingException {
		// Create a new Stock object
		Stock stock = new Stock();
		stock.setStockCode(code);
		stock.setStockCost(cost);
		
		// Convert Stock object to JSON string
		String result = converter.converter(stock);
		
		// Send the message using the producer service
		if (result != null) {
			service.SendMsg(result);
			return "Success";
		} else {
			return "Failure";
		}
	}
	
}

package in.jai.Cloud.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.jai.Cloud.Converter.JsonToString;
import in.jai.Cloud.Entity.Stock;
import in.jai.Cloud.producer.ProducerService;

@RestController
@RequestMapping("/v1/api/stock")
public class StockController {
	
	@Autowired
	ProducerService Service;
	
	@Autowired
	JsonToString convert;

	/*
	 * METHOD : GET
	 * INPUT  : Code,Cost(@RequestPatam)
	 * OUTPUT : String
	 * PATH   :/v1/api/stock/send 
	 */
	@GetMapping("/send")
	public String ReadInput(@RequestParam Double Cost,@RequestParam String code) throws JsonProcessingException  {
			
		//creating of holding cost and code
		Stock stock = new Stock();
		stock.setStockCode(code);
		stock.setStockCost(Cost);
		
		//convert object to jsonString format and send it to service
		String result = convert.converter(stock);
		
		
		//send that data to send Message;
		if(result != null) {
		Service.SendMsg(result);
		return "Sucess";
		}
		else return "fail";
			
		
		
		
	
		
	}
	
}

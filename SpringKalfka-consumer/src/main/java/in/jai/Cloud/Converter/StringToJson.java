package in.jai.Cloud.Converter;


import org.springframework.stereotype.Component;   

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.jai.Cloud.Entity.Stock;

@Component
public class StringToJson {
	
	public Stock converter(String message) throws JsonProcessingException {
	    ObjectMapper objectMapper = new ObjectMapper();

	    System.out.println("Raw JSON message: " + message);
	    
	    Stock stock = objectMapper.readValue(message, Stock.class);
	    System.out.println("Converted Stock object: " + stock);
	    
	    return stock;
	}




}

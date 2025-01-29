package in.jai.Cloud.Converter;


import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.jai.Cloud.Entity.Stock;

@Component
public class JsonToString {
	
	public String converter(Stock stock) throws JsonProcessingException {
		
		ObjectMapper om = new ObjectMapper();
		String value = om.writeValueAsString(stock);
		
		return value;
		
	}

}

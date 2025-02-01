package in.jai.Cloud.converter;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.jai.Cloud.Entity.Stock;

@Component
public class JsonToString {

	
	public String converter(Stock stock) throws JsonProcessingException {
		ObjectMapper om = new ObjectMapper();
		 String writeValueAsString = om.writeValueAsString(stock);
		 
		 return writeValueAsString;
	}
}

package in.jai.Cloud.Consumer;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.jai.Cloud.Entity.StockApi;
import in.jai.Cloud.Repository.StockRepository;

@Service
public class StockConsumer {
	@Autowired
	private StockRepository repo;
	
	@Autowired
	ObjectMapper mapper;
	
	@KafkaListener(topics = "${my.topic.name}", groupId = "SBMS")
    public void consume(String message) throws JsonMappingException, JsonProcessingException {
        System.out.println("Message received from Kafka: " + message);
        
        
			 StockApi value = mapper.readValue(message, StockApi.class);
			 repo.save(value);
			 
			 System.out.println(value);
			 
			 
		
		
        
       
    }
}

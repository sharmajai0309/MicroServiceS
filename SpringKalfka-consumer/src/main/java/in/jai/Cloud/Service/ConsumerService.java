package in.jai.Cloud.Service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.core.pattern.Converter;
import in.jai.Cloud.Converter.StringToJson;
import in.jai.Cloud.Entity.Stock;
import in.jai.Cloud.StockRespository.Respository;
import in.jai.Cloud.StockService.StockService;
import in.jai.Cloud.StockService.StockServiceimpl;

@Component
public class ConsumerService {

	 @Autowired
	    private StockService stockService;

	    @Autowired
	    private ObjectMapper objectMapper;

	    @KafkaListener(topics = "${my.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
	    public void readData(String message) {
	        try {
	            System.out.println("Message received from Kafka: " + message);

	            // Convert JSON string to Stock object
	            Stock stock = objectMapper.readValue(message, Stock.class);

	            System.out.println("Converted Stock object: " + stock);

	            // Save to the database
	            if (stock != null && stock.getStockCode() != null && stock.getStockCost() != null) {
	                stockService.saveStock(stock);
	                System.out.println("Stock saved successfully in database");
	            } else {
	                System.out.println("Invalid data: Stock not saved. Stock code or cost is null.");
	            }

	        } catch (Exception e) {
	            System.err.println("Error processing message: " + e.getMessage());
	        }
	    }
	}


	


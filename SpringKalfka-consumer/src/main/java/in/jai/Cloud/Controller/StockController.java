package in.jai.Cloud.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.jai.Cloud.Entity.Stock;
import in.jai.Cloud.StockService.StockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/v1/api/stock")
public class StockController {
	
	 @Autowired
	    private StockService stockService;

	 @PostMapping
	    public String saveStock(@RequestBody Stock stock) {
	        try {
	            stockService.saveStock(stock);
	            return "Stock saved successfully!";
	        } catch (Exception e) {
	            return "Error saving stock: " + e.getMessage();
	        }
	    }
}
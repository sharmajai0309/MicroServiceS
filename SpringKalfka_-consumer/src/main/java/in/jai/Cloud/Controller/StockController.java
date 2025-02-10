package in.jai.Cloud.Controller;

import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController;

import in.jai.Cloud.Entity.StockApi;
import in.jai.Cloud.Repository.StockRepository;
import in.jai.Cloud.Service.StockService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/v1/api/stock")
public class StockController {
	
	@Autowired
	private StockRepository repo;
	
	@Autowired
	private StockService service;

	
	@GetMapping("/getall")
	public ResponseEntity<List<StockApi>> getAllStocks() {
	    List<StockApi> allStocks = repo.findAll();
	    
	    if (allStocks.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }

	    return ResponseEntity.ok(allStocks);
	}
	
	
	@GetMapping("/get/{id}")
	public ResponseEntity<StockApi> getStock(@PathVariable Integer id){
		
		  StockApi stocks = service.getStocks(id);
		   
		   return ResponseEntity.ok(stocks);
		
	}

	
}

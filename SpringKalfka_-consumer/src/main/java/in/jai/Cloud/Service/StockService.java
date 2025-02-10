package in.jai.Cloud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import in.jai.Cloud.Entity.StockApi;
import in.jai.Cloud.Repository.StockRepository;

@Service
public class StockService {
	
	@Autowired
	private StockRepository repo;
	
	
	
	@Cacheable(value = "stocks", key = "#id")
	public StockApi getStocks(Integer id){
		StockApi stock = repo.findById(id).get();
		return stock;	
	}
	

}

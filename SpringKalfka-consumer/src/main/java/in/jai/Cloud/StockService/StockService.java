package in.jai.Cloud.StockService;

import java.util.List;

import in.jai.Cloud.Entity.Stock; 

public interface StockService {
	
	void saveStock(Stock stock);
	
	 public List<Stock> allStock();
	

}

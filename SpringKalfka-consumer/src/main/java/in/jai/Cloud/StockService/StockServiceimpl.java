package in.jai.Cloud.StockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.jai.Cloud.Entity.Stock;
import in.jai.Cloud.StockRespository.Respository;

@Service
public class StockServiceimpl implements StockService{
	
	@Autowired
    private Respository stockRepository;

    @Override
    public void saveStock(Stock stock) {
    	stockRepository.save(stock);
    }

	@Override
	public List<Stock> allStock() {
		// TODO Auto-generated method stub
		return null;
	}
	 
}

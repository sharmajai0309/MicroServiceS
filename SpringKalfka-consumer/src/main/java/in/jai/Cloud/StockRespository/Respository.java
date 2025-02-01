package in.jai.Cloud.StockRespository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.jai.Cloud.Entity.Stock;

@Repository
public interface Respository extends JpaRepository<Stock, Integer> {
}

package in.jai.Cloud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.jai.Cloud.Entity.StockApi;

@Repository
public interface StockRepository extends JpaRepository<StockApi, Integer> {

}

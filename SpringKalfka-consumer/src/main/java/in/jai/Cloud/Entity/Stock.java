package in.jai.Cloud.Entity;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;  
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Stock {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer stockId;

	   
	    private String stockCode;

	   
	    private Double stockCost;

}

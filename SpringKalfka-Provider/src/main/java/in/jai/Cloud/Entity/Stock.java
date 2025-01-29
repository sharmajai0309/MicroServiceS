package in.jai.Cloud.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

	private Integer StockId;
	private String StockCode;
	private Double StockCost;
}

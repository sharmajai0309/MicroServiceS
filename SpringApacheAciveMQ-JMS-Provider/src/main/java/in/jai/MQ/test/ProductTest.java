package in.jai.MQ.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import in.jai.MQ.service.ProductService;


@Component
public class ProductTest {
	
	@Autowired
	ProductService productService;
	 
	
	
	@Scheduled(cron = "*/10 * * * * *")
	public void message() {
		productService.sendDate("seconds counting ::" + new Date());

		System.out.println("Message Sended to Product Service from Product test");
	}

}

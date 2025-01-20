package in.jai.Cloud.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
	
	
	@JmsListener(destination = "${my.app.desti-name}")
	public void readData(String data) {
		System.out.println("message recieved from Queue MQ #2 ::"+data);
	}

}

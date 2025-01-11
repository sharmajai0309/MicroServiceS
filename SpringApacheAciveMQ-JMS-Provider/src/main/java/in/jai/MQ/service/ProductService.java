package in.jai.MQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductService {

		@Autowired
		private JmsTemplate jmt;
		
		@Value("${my.app.desti-name}")
		private String destination;
		
		
		public void sendDate(String message) {
			
			//Message createMessage(Session session) throws JMSExceptions
			
//			Session is and interface coming from JMS
			
			jmt.send(destination, session -> session.createTextMessage(message));
			System.out.println("Message Sended to Queue from ProductService");
		}
	}



package in.jai.MQ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Component
public class ProductService {

		@Autowired
		private JmsTemplate jmt;
		
		@Value("${my.app.desti-name}")
		private String destination;
		
		
//		public void sendDate(String message) {
//			
//			//Message createMessage(Session session) throws JMSExceptions
//			
////			Session is and interface coming from JMS
//			
//			jmt.send(destination,new MessageCreator() {
//				
//				@Override
//				public Message createMessage(Session session) throws JMSException {
//					TextMessage textmessage  = session.createTextMessage(message);
//					return textmessage;
//				}
//			});
//			System.out.println("Message Sended to Queue from ProductService");
//		}
		
		public void sendDate(String message) {
			jmt.send(destination, session ->session.createTextMessage(message) );
		}
	}



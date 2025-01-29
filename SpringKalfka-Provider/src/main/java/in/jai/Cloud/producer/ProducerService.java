package in.jai.Cloud.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, String> kft;

	@Value("${my.topic.name}")
	private String TopicName;
	
	
	public void SendMsg(String message) {
		kft.send(TopicName, message);
	}
	
	
}
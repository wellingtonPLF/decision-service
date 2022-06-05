package project.pd.microservice.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import project.pd.microservice.model.Decision;

@Component
public class DecisionProducer {
	
	@Value("${sr.rabbitmq.exchange_1.name}")
	private String exchangeName;
	
	@Value("${sr.rabbitmq.queue_1.name}")
	private String queue_1;
	
	@Value("${sr.rabbitmq.queue_5.name}")
	private String queue_5;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public Decision sendToQueue(String key, Decision decision) {
		this.rabbitTemplate.convertAndSend(this.exchangeName, this.queue_1 + "_" + key, decision);
		return decision;
	}
	
	public void sendToDelete(String key, Decision decision) {
		this.rabbitTemplate.convertAndSend(this.exchangeName, this.queue_5 + "_" + key, decision);
	}
}

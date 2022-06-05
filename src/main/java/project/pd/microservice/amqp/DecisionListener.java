package project.pd.microservice.amqp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import project.pd.microservice.model.Decision;
import project.pd.microservice.service.DecisionService;

@Component
public class DecisionListener {
	
	@Autowired
	private DecisionService decisionService;
	
	@RabbitListener(queues = "${sr.rabbitmq.queue_2.name}")
	public void listen1(@Payload Decision decision) {
		this.decisionService.insertOrUpdate(decision);
	}
	
	@RabbitListener(queues = "${sr.rabbitmq.queue_3.name}")
	public void listen2(@Payload String message) {
		System.out.println(message);
	}
	
	@RabbitListener(queues = "${sr.rabbitmq.queue_4.name}")
	public void listen3(@Payload List<Long> decisions) {
		for(int i = 0; i < decisions.size(); i++) {
			this.decisionService.delete(decisions.get(i));
		}
	}
	
	@RabbitListener(queues = "${sr.rabbitmq.queue_6.name}")
	public void listen4(@Payload Long decisionID) {
		this.decisionService.delete(decisionID);
	}
}
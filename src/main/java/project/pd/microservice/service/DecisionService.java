package project.pd.microservice.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import project.pd.microservice.amqp.DecisionProducer;
import project.pd.microservice.model.Decision;
import project.pd.microservice.repository.DecisionRepository;

@Service
public class DecisionService {
	
	@Autowired
	private DecisionRepository decisionRepository;
	
	@Autowired
	private DecisionProducer decisionProducer;

	public List<Decision> getDecisions() {
		return this.decisionRepository.findAll(); 
	}

	public Decision getDecisionById(Long idDecision) {
		return this.decisionRepository.findById(idDecision).orElse(null);
	}
	
	public Decision checkUserDecision(Decision decision) {
		Decision check = this.decisionRepository.save(decision);
		return this.decisionProducer.sendToQueue("bk_1", check);
	}

	@Transactional
	public Decision insertOrUpdate(Decision decision) {
		return this.decisionRepository.save(decision);
	}

	public void delete(Long idDecision) {
		Decision decision = this.decisionRepository.findById(idDecision).orElse(null);
		this.decisionProducer.sendToDelete("bk_1", decision);
		this.decisionRepository.deleteById(idDecision);
	}

}

package project.pd.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import project.pd.microservice.model.Decision;
import project.pd.microservice.service.DecisionService;

@RestController
@RequestMapping("/decisions")
public class DecisionController {
	
	@Autowired
	private DecisionService decisionService;
	
	@GetMapping("/")
   	public List<Decision> getDecisions() {
       	return this.decisionService.getDecisions();
   	}
	
   	@GetMapping("/{idDecision}")
   	public Decision getDecisionById(@PathVariable("idDecision") Long idDecision) {
       	return this.decisionService.getDecisionById(idDecision);
   	}
   
   	@PostMapping("/")
   	public Decision addDecision(@RequestBody Decision decision){
       	return this.decisionService.checkUserDecision(decision);
   	}
   
   	@PutMapping("/{idDecision}")
   	public Decision updateDecision(@RequestBody Decision decision){
	   	return this.decisionService.insertOrUpdate(decision);
   	}	

   	@DeleteMapping("/{idDecision}")
   	public void deleteDecision(@PathVariable("idDecision") Long idDecision) {
	   	this.decisionService.delete(idDecision);
   	}	
}

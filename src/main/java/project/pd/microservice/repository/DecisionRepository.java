package project.pd.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.pd.microservice.model.Decision;

public interface DecisionRepository extends JpaRepository<Decision, Long>{
	
}

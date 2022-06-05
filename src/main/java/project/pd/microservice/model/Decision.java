package project.pd.microservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_decision")
public class Decision {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDecision;
	private String name;
	private Long iduser;
	
	public Long getIdDecision() {
		return idDecision;
	}
	public void setIdDecision(Long idDecision) {
		this.idDecision = idDecision;
	}
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

package project.pd.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import project.pd.microservice.model.Decision;

@SpringBootApplication
@EnableEurekaServer
public class MakingDecisionDecisionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakingDecisionDecisionApplication.class, args);
	}
}

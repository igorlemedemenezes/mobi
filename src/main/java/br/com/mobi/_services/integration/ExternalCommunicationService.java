package br.com.mobi._services.integration;

import org.hibernate.secure.spi.IntegrationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import br.com.mobi.exceptions.RuleException;

@Service
public class ExternalCommunicationService {

	
    private final RestTemplate restTemplate;
    private final Environment environment;

    @Autowired
    public ExternalCommunicationService(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }
    
    public void canThisCpfVote(String cpf) {
    	try {
    		String url = environment.getProperty("integration-check-cpf") + cpf;
    		ResponseEntity<?> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
    		
        	if(response.getStatusCode() == HttpStatus.NOT_FOUND)
        		throw new RuleException("Invalid CPF!");
    	}catch(HttpStatusCodeException e) {
    		throw new IntegrationException("An error occurred with the communication of the CPF validation server.");
    	}
		
    	

    		
    	
    	
    }
    
}

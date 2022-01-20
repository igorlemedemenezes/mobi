package br.com.mobi._services;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobi._model.AgendaModel;
import br.com.mobi._model.SessionModel;
import br.com.mobi.dto.SessionDTO;
import br.com.mobi.exceptions.RuleException;

@Service
public class SessionService {

	private final Environment env;
	
	@Autowired
	public SessionService(Environment env) {
		this.env = env;
	}
	
	@Autowired
	private AgendaService agendaService;
	
	@Transactional
	public AgendaModel openSession(@Valid SessionDTO sessionDTO) {
		
		SessionModel session;
		AgendaModel agenda = agendaService.findById(sessionDTO.getIdAgenda());
		
		if(sessionDTO.getExpiration() != null)
			session = new SessionModel(null, sessionDTO.getExpiration(), agenda);
		else 
			session = new SessionModel(null, 
					LocalDateTime.now().plusMinutes(Integer.parseInt(Objects.requireNonNull(env.getProperty("expiration.minutes")))), agenda); 
		agenda.setSession(session);
		return agendaService.save(agenda);
	}

	public void isItExpired(LocalDateTime expiration) {
		if(LocalDateTime.now().isAfter(expiration))
			throw new RuleException("This agenda is already expired.");
	}
	
}

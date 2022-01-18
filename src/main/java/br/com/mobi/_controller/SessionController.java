package br.com.mobi._controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mobi._model.AgendaModel;
import br.com.mobi._services.SessionService;
import br.com.mobi.dto.SessionDTO;

@RestController
@RequestMapping(value = "/session")
public class SessionController {

	
	@Autowired
	private SessionService service;
	
	@PostMapping(value = "/create-session")
	private ResponseEntity<AgendaModel> openSession(@Valid @RequestBody SessionDTO sessionDTO) throws URISyntaxException{
		AgendaModel agenda = service.openSession(sessionDTO);
		return ResponseEntity.created(new URI(agenda.getId().toString())).build();
	}
	
}

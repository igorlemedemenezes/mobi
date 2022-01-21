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
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/session")
public class SessionController {

	
	@Autowired
	private SessionService service;
	
    @ApiOperation(value="Create session.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Create session."),
    })	
	@PostMapping(value = "/create-session")
	private ResponseEntity<AgendaModel> openSession(@Valid @RequestBody SessionDTO sessionDTO) throws URISyntaxException{
		AgendaModel agenda = service.openSession(sessionDTO);
		return ResponseEntity.created(new URI(agenda.getId().toString())).build();
	}
	
}

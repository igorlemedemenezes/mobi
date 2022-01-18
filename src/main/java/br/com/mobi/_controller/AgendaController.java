package br.com.mobi._controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.mobi._model.AgendaModel;
import br.com.mobi._services.AgendaService;
import br.com.mobi.dto.AgendaResultDTO;
import br.com.mobi.dto.AgendaDTO;
import br.com.mobi.dto.VoteDTO;
//import br.com.mobi.response.handler.ResponseHandler;

@RestController
@RequestMapping(value = "/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
//	@Autowired
//	private ResponseHandler responseHandler;
	
	@PostMapping
	private ResponseEntity<Void> insert(@Valid @RequestBody AgendaDTO agendaDTO){
		AgendaModel agenda = agendaService.insert(agendaDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agenda.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PostMapping(value = "/receive-votes")
	private ResponseEntity<Void> receiveVotes(@Valid @RequestBody VoteDTO voteDTO){
		agendaService.addVote(voteDTO);
		return ResponseEntity.ok().body(null);
	}
	
	@GetMapping(value = "/result-agenda/{id}")
	private ResponseEntity<AgendaResultDTO> getResultAgenda(@PathVariable Integer id){
		AgendaResultDTO agendaResultDTO = agendaService.getResultAgenda(id);
		return ResponseEntity.ok().body(agendaResultDTO);
	}
	
}
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
import br.com.mobi.dto.AgendaDTO;
import br.com.mobi.dto.AgendaResultDTO;
import br.com.mobi.dto.VoteDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "agenda")
@RequestMapping(value = "/v1/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaService agendaService;
	
    @ApiOperation(value="Creating agenda.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Agenda created.")
    })
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody AgendaDTO agendaDTO){
		AgendaModel agenda = agendaService.insert(agendaDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(agenda.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
    @ApiOperation(value="Receive new vote.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Vote receive.")
    })
	@PostMapping(value = "/receive-votes")
	public ResponseEntity<Void> receiveVotes(@Valid @RequestBody VoteDTO voteDTO){
		agendaService.addVote(voteDTO);
		return ResponseEntity.ok().body(null);
	}
	
    @ApiOperation(value="Return result.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Return result."),
            @ApiResponse(code = 404, message = "Not found.")
    })
	@GetMapping(value = "/result-agenda/{id}")
	public ResponseEntity<AgendaResultDTO> getResultAgenda(@PathVariable Integer id){
		AgendaResultDTO agendaResultDTO = agendaService.getResultAgenda(id);
		return ResponseEntity.ok().body(agendaResultDTO);
	}
	
}
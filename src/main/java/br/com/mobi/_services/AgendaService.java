package br.com.mobi._services;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mobi._model.AgendaModel;
import br.com.mobi._model.VoteModel;
import br.com.mobi._repository.AgendaRepository;
import br.com.mobi._services.integration.ExternalCommunicationService;
import br.com.mobi.dto.AgendaDTO;
import br.com.mobi.dto.AgendaResultDTO;
import br.com.mobi.dto.VoteDTO;
import br.com.mobi.exceptions.ObjectNotFoundException;
import br.com.mobi.exceptions.RuleException;

@Service
public class AgendaService {

	@Autowired 
	private AgendaRepository repo;

	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private VoteService voteService;
	
	@Autowired
	private ExternalCommunicationService externalCommunicationService;
	
	public AgendaModel save(AgendaModel agenda) {
		return repo.save(agenda);
	}
	
	@Transactional	
	public AgendaModel insert(@Valid AgendaDTO agendaDTO) {
		AgendaModel agenda = new AgendaModel(null, agendaDTO.getNome(), null, null);
		return repo.save(agenda);
	}

	@Transactional
	public void addVote(VoteDTO voteDTO) {
		AgendaModel agenda = findById(voteDTO.getIdAgenda());
		sessionService.isItExpired(agenda.getSession().getExpiration());
		hasThisAssociatedAlreadyVoted(agenda, voteDTO);
		externalCommunicationService.isThisCpfAbleToVote(voteDTO.getCpf());
		addVoteToAgenda(voteDTO, agenda);
	}
	
	public AgendaModel findById(Integer id) {
		Optional<AgendaModel> agenda = repo.findById(id);
		
		if(agenda.isPresent())
			return agenda.get();
		
		throw new ObjectNotFoundException("Agenda not found to id: " + id);
	}
	
	private void addVoteToAgenda(VoteDTO voteDTO, AgendaModel agenda) {
		VoteModel vote = voteService.getVote(voteDTO);
		agenda.getVotes().add(vote);
		save(agenda);
	}
	
	public AgendaResultDTO getResultAgenda(Integer id) {
		AgendaModel agenda = findById(id);
		return new AgendaResultDTO(agenda.getVotes().size(), getResultVote(agenda));
	}
	
	public String getResultVote(AgendaModel agenda) {
		
		Integer numberOfVotesSim = 0;
		Integer numberOfVotesNao = 0;
		
		for(VoteModel vote : agenda.getVotes()) {
			if(vote.getTypeVoteModel().getDescriptionVote() == "Sim") 
				numberOfVotesSim++; 
			else
				numberOfVotesNao++;
		}
		
		return numberOfVotesSim > numberOfVotesNao ? "Sim" : "Não";
	}
	
	public void hasThisAssociatedAlreadyVoted(AgendaModel agenda, VoteDTO voteDTO){
		
		Optional<VoteModel> voteAlreadyExist = agenda.getVotes().stream().filter(e -> e.getAssociate().getCPF().equals(voteDTO.getCpf())).findFirst();
		
		if(voteAlreadyExist.isPresent())
			throw new RuleException("This user already has a vote on this agenda.");
		
	}

}

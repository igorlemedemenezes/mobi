package br.com.mobi._services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobi._model.AssociateModel;
import br.com.mobi._model.TypeVoteModel;
import br.com.mobi._model.VoteModel;
import br.com.mobi.dto.VoteDTO;

@Service
public class VoteService {
	
	@Autowired
	private AssociateService associateService;
	
	@Autowired
	private TypeVoteService typeVoteService;
	
	public VoteModel getVote(VoteDTO voteDTO) {
		AssociateModel associate = associateService.findByCPF(voteDTO.getAssociate().getCpf());
		TypeVoteModel typeVote = typeVoteService.findTypeVoteByDescription(voteDTO.getVote());
		return new VoteModel(null, typeVote, associate);
	}
	
}

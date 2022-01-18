package br.com.mobi._services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobi._model.TypeVoteModel;
import br.com.mobi._repository.TypeVoteRepository;
import br.com.mobi.exceptions.ObjectNotFoundException;

@Service
public class TypeVoteService {

	@Autowired
	private TypeVoteRepository repo;
	
	public TypeVoteModel findTypeVoteByDescription(String description) {
		List<TypeVoteModel> typeVotes = repo.findAll();
		
		Optional<TypeVoteModel> typeVote = typeVotes.stream().filter(e -> e.getDescriptionVote().equals(description)).findFirst();
		
		if(typeVote.isPresent())
			return typeVote.get();
		
		throw new ObjectNotFoundException("Type vote not found."); 
		
	}
	
}

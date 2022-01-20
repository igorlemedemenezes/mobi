package br.com.mobi.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobi._model.TypeVoteModel;
import br.com.mobi._repository.TypeVoteRepository;

@Service
public class DBService {

	@Autowired
	private TypeVoteRepository typeVoteRepo;
	
	public void instantiateTestDatabase() {
		
		TypeVoteModel tpVoteSim = new TypeVoteModel(null, "Sim");
		TypeVoteModel tpVoteNao = new TypeVoteModel(null, "Não");
		
		typeVoteRepo.save(tpVoteSim);
		typeVoteRepo.save(tpVoteNao);
		
	}

	
	
	
	
}

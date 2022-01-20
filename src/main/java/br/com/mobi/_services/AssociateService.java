package br.com.mobi._services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobi._model.AssociateModel;
import br.com.mobi._repository.AssociateRepository;

@Service
public class AssociateService {

	@Autowired
	private AssociateRepository repo;
	
	public AssociateModel findByCPF(String cpf) {
		Optional<AssociateModel> associate = repo.findByCPF(cpf);
		
		if(associate.isPresent())
			return associate.get();
		
		return new AssociateModel(null, cpf);
		
	}
	
}

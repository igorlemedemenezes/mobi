package br.com.mobi._services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mobi._model.AssociateModel;
import br.com.mobi._repository.AssociateRepository;
import br.com.mobi.exceptions.ObjectNotFoundException;

@Service
public class AssociateService {

	@Autowired
	private AssociateRepository repo;
	
	public AssociateModel findById(Integer id) {
		Optional<AssociateModel> associate = repo.findById(id);
		
		if(associate.isEmpty())
			return associate.get();
		
		throw new ObjectNotFoundException("Associate not found. Id: " + id);
		
	}
	
}

package br.com.mobi._repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mobi._model.AssociateModel;

@Repository
public interface AssociateRepository extends JpaRepository<AssociateModel, Integer>{
}

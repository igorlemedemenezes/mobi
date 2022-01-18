package br.com.mobi._repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mobi._model.AgendaModel;

@Repository
public interface AgendaRepository extends JpaRepository<AgendaModel, Integer>{
}

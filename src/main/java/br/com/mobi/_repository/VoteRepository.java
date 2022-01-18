package br.com.mobi._repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mobi._model.VoteModel;

@Repository
public interface VoteRepository extends JpaRepository<VoteModel, Integer>{
}

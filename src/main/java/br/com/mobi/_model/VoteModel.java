package br.com.mobi._model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "vote")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VoteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private TypeVoteModel typeVoteModel;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	private AssociateModel associate;
	
}

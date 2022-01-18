package br.com.mobi._model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "agenda")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AgendaModel implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private Integer Id;
	
	private String nome;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "agenda")
	private SessionModel session;
	
	@ManyToMany
	private List<VoteModel> votes;
	
}

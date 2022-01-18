package br.com.mobi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteDTO {

	private String cpf;
	private Integer idAgenda;
	private String descriptionVote;
	
}

package br.com.mobi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteDTO {

	private String vote;
	private AgendaDTO agenda;
	private AssociateDTO associate;
	
}

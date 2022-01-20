package br.com.mobi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VoteDTO {

	private String vote;
	private AgendaDTO agenda;
	private AssociateDTO associate;
	
}

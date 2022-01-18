package br.com.mobi.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class VoteDTO {

	private Integer idAssociate;
	private Integer idAgenda;
	private String descriptionVote;
	
}

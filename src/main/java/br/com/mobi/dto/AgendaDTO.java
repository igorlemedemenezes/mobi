package br.com.mobi.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AgendaDTO {

	@NotNull
	private Integer id;
	
	private String name;
	
}

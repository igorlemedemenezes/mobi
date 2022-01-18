package br.com.mobi.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SessionDTO {
	
	private Integer idAgenda;
	private LocalDateTime expiration;
	
}

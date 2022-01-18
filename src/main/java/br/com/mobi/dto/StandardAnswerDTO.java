package br.com.mobi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandardAnswerDTO {

	private Long timestamp;
	private Integer status;
	private String response;
	private String message;
	private String path;
	private Object obj;
	
}

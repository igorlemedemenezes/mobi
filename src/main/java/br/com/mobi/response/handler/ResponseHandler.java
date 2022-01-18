 package br.com.mobi.response.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.mobi.dto.StandardAnswerDTO;
import br.com.mobi.exceptions.ObjectNotFoundException;
import br.com.mobi.exceptions.RuleException;

@ControllerAdvice
public class ResponseHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardAnswerDTO> notFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardAnswerDTO dto = new StandardAnswerDTO(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Object not found.", e.getMessage(), request.getRequestURI(),null);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
	}
	
	@ExceptionHandler(RuleException.class)
	public ResponseEntity<StandardAnswerDTO> badRequest(RuleException e, HttpServletRequest request){
		
		StandardAnswerDTO dto = new StandardAnswerDTO(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                "Invalid business rule.", e.getMessage(), request.getRequestURI(), null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dto);
	}
	
    public ResponseEntity<StandardAnswerDTO> success(Object obj, HttpServletRequest request) {
    	StandardAnswerDTO resp = new StandardAnswerDTO(System.currentTimeMillis(), HttpStatus.OK.value(), "Success",
                "Data processed successfully.", request.getRequestURI(), obj);
        return ResponseEntity.ok().body(resp);
    }
	
}

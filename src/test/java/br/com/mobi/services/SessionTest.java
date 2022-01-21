package br.com.mobi.services;

import java.net.URISyntaxException;
import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.mobi._services.SessionService;

@RunWith(MockitoJUnitRunner.class)
public class SessionTest {
	
	@Mock
	private SessionService sessionService;

    @Test
    public void CallFunctionIsItExpired_ShouldNotBreak() throws URISyntaxException {
    	sessionService.isItExpired(LocalDateTime.now().plusMinutes(2));
    }
    
}

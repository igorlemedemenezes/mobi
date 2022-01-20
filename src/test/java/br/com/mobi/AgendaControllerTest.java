package br.com.mobi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.mobi._controller.AgendaController;
import br.com.mobi._services.AgendaService;
import br.com.mobi.dto.AgendaDTO;
import br.com.mobi.dto.AgendaResultDTO;
import br.com.mobi.dto.AssociateDTO;
import br.com.mobi.dto.VoteDTO;

@RunWith(MockitoJUnitRunner.class)
public class AgendaControllerTest {

    @Mock
    public AgendaService agendaService;

    @InjectMocks
    public AgendaController agendaController;
	
    @Test
    public void CallEndPointCreateAgenda_ShouldCreateAgenda() throws URISyntaxException {
        AgendaDTO agendaDTO = new AgendaDTO(null, new String("agenda"));
        ResponseEntity<?> response = agendaController.insert(agendaDTO);

        assertEquals(response.getStatusCodeValue(), HttpStatus.CREATED);
        assertNotNull(response.getHeaders().get("Location"));
    }
    
    @Test
    public void CallEndPointReceiveVote_ShouldAddNewVote() throws URISyntaxException {

        agendaController.insert(new AgendaDTO(null, new String("agenda")));
    	
    	String vote = "Sim";
    	AssociateDTO associateDTO = new AssociateDTO("40606977880");
    	AgendaDTO agendaDTO = new AgendaDTO(1, "");
        VoteDTO voteDTO = new VoteDTO(vote, agendaDTO,associateDTO);
        
        ResponseEntity<?> response = agendaController.receiveVotes(voteDTO);

        assertEquals(response.getStatusCodeValue(), HttpStatus.OK);
        assertEquals(response.getBody(), null);
    }
    
    @Test
    public void CallEndPointReturnAgenda_ShouldReturnResult() throws URISyntaxException {

        agendaController.insert(new AgendaDTO(null, new String("agenda")));
    	
    	String vote = "Sim";
    	AssociateDTO associateDTO = new AssociateDTO("40606977880");
    	AgendaDTO agendaDTO = new AgendaDTO(1, "");
        VoteDTO voteDTO = new VoteDTO(vote, agendaDTO,associateDTO);
        
        agendaController.receiveVotes(voteDTO);

        ResponseEntity<AgendaResultDTO> response = agendaController.getResultAgenda(1);        
        
        assertEquals(response.getStatusCodeValue(), HttpStatus.OK);
        assertEquals(response.getBody().getNumberOfVotes(), 1);
        assertEquals(response.getBody().getResult(), "Sim");

        
    }
    
    
}

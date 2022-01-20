package br.com.mobi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.mobi._model.AgendaModel;
import br.com.mobi._model.AssociateModel;
import br.com.mobi._model.TypeVoteModel;
import br.com.mobi._model.VoteModel;
import br.com.mobi._services.AgendaService;

@RunWith(MockitoJUnitRunner.class)
public class AgendaTest {

    @Mock
	private AgendaService agendaService;
	
    @Test
    public void CallFunctionGetResultVote_ShouldReturnSim() throws URISyntaxException {

    	TypeVoteModel tv1 = new TypeVoteModel(1, "Não");
    	TypeVoteModel tv2 = new TypeVoteModel(1, "Sim");
    	
    	AssociateModel am1 = new AssociateModel(1, "10203944857");
    	AssociateModel am2 = new AssociateModel(1, "10203944855");
    	AssociateModel am3 = new AssociateModel(1, "10203944856");
    	
    	List<VoteModel> list = new ArrayList<>();
    	list.add(new VoteModel(null, tv2, am1));
    	list.add(new VoteModel(null, tv1, am2));
    	list.add(new VoteModel(null, tv2, am3));
    	
    	AgendaModel agenda = new AgendaModel(1, "agenda1", null, list);
    	
    	String resultVote = agendaService.getResultVote(agenda);
    	
        assertEquals(resultVote, "Sim");
        assertNotNull(resultVote);
    }
    
    @Test
    public void CallFunctionGetResultVote_ShouldReturnNao() throws URISyntaxException {

    	TypeVoteModel tv1 = new TypeVoteModel(1, "Não");
    	TypeVoteModel tv2 = new TypeVoteModel(1, "Sim");
    	
    	AssociateModel am1 = new AssociateModel(1, "10203944857");
    	AssociateModel am2 = new AssociateModel(1, "10203944855");
    	AssociateModel am3 = new AssociateModel(1, "10203944856");
    	
    	List<VoteModel> list = new ArrayList<>();
    	list.add(new VoteModel(null, tv1, am1));
    	list.add(new VoteModel(null, tv1, am2));
    	list.add(new VoteModel(null, tv2, am3));
    	
    	AgendaModel agenda = new AgendaModel(1, "agenda1", null, list);
    	
    	String resultVote = agendaService.getResultVote(agenda);
    	
        assertEquals(resultVote, "Não");
        assertNotNull(resultVote);
    }
    
}

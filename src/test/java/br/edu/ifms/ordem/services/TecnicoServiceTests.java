package br.edu.ifms.ordem.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.edu.ifms.ordem.repositories.TecnicoRepository;

@ExtendWith(SpringExtension.class)
public class TecnicoServiceTests {

	
	
	@InjectMocks
	private TecnicoService service;
	
	
	@Mock
	private TecnicoRepository repository;
	
	
	
	@Test
	private void deleteDeveriaExcluirRegistroQuandoIdExistir() {
		 Long idExistente = 1L;
		 service.delete(idExistente);
		 

	}
		
		

	
	
	
	
	
	
}

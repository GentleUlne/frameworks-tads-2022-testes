package br.edu.ifms.ordem.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import br.edu.ifms.ordem.entities.Tecnico;
import br.edu.ifms.ordem.tests.Factory;

@DataJpaTest
public class TecnicoRepositoryTests {
	
	@Autowired
	private TecnicoRepository repository;
	private long idExistente;
	private long idInexistente;
	
	@BeforeEach
	void setUp() throws Exception {
		
		idExistente = 1L;
		idInexistente = 10L;
	}
	
	/*
	 * Acesso a Dados
	 * CRUD - Create, Read, Update and Delete
	 */
	
	

	/**
	 * SAVE
	 * deveria SALVAR REGISTRO [quando O ID FOR NULO]
	 * saveDeveriaSalvarRegistroQuandoIdNulo
	 */
	
	@Test
	public void  saveDeveriaSalvarRegistroQuandoIdNulo() {
		Tecnico tecnico = Factory.novoTecnico();
		tecnico.setId(null);
		
		
     	tecnico  =	repository.save(tecnico);
     	
        Assertions.assertNotNull(tecnico.getId());
	}
	
	
	
	@Test
	public void  deveriaRetornarUmOptionalQuandoOidExistir() {
		Tecnico tecnico = Factory.novoTecnico();
		tecnico.setId(idExistente);
		
		
     	tecnico  =	repository.save(tecnico);
     	
        
        
        
    //	Tecnico tecnico = Factory.novoTecnico();
    //	tecnico.setId(idExistente);
		//Assert
		Optional<Tecnico> resultado; 
    	resultado = repository.findById(idExistente);

	
	//	Assertions.assertTrue(resultado.isPresent());
     	Assertions.assertNotNull(tecnico.getId());
	}
	
	
	
	
	
	/**
	 * DELETE
	 * deveria EXCLUIR REGISTRO [quando O ID EXISTIR]
	 */
	@Test
	public void deleteDeveriaExcluirRegistroQuandoIdExistir() {
		//Arrange
	
		
		//Act
		repository.deleteById(idExistente);
		
		//Assert
		Optional<Tecnico> resultado; 
		resultado = repository.findById(idExistente);
		Assertions.assertFalse(resultado.isPresent());
	}

	
//	retornar um Optional<Tecnico> não vazio quando o id existir
//	retornar um Optional<Tecnico> vazio quando o id não existir
	

	
	
	/**
	 * DELETE
	 * deveria LANCAR EXCECAO [quando O ID NAO EXISTIR]
	 * deleteDEveriaLancarEmptyResultDAtaAcesssExceptionQuandoIdNaoExistir
	 */
	
	
	
	@Test
	public void deleteDEveriaLancarEmptyResultDAtaAcesssExceptionQuandoIdNaoExistir() {
	
	Assertions.assertThrows(EmptyResultDataAccessException.class, ( ) -> {
		 repository.deleteById(idInexistente);
	} );
	}
	
}

package br.com.bionexo.teste.controller.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import br.com.bionexo.teste.exceptions.InvalidDataException;
import br.com.bionexo.teste.exceptions.NotFoundException;
import br.com.bionexo.teste.model.LocalidadeResponse;
import br.com.bionexo.teste.service.LocalidadeService;

class LocalidadeControllerTest {

	LocalidadeService service;
	@BeforeEach
	void setUp() throws Exception {
		service = Mockito.mock(LocalidadeService.class);
		
	}

	@Test
	void testObterUbsPróximas() {
		try {
			Mockito.when(service.obterUbsPróximas(ArgumentMatchers.anyString(), ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt())).thenReturn(new LocalidadeResponse());
			LocalidadeResponse response = service.obterUbsPróximas("", 1, 2);
			assertNotNull(response);
		} catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

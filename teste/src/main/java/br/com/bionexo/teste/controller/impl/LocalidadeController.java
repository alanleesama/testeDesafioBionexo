package br.com.bionexo.teste.controller.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.bionexo.teste.controller.api.LocalidadeControllerAPI;
import br.com.bionexo.teste.exceptions.InvalidDataException;
import br.com.bionexo.teste.exceptions.NotFoundException;
import br.com.bionexo.teste.service.LocalidadeService;
import br.com.bionexo.teste.errors.Error;

@RestController
public class LocalidadeController implements LocalidadeControllerAPI{
	
	private LocalidadeService service;
	
	@Autowired
	public LocalidadeController(LocalidadeService service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<?> obterUbsPróximas(@PathVariable("query") String query, @PathVariable("page") Integer page, @PathVariable("per_page") Integer per_page ) {
		try {
			return ResponseEntity.ok(service.obterUbsPróximas(query, page, per_page));
		}catch(InvalidDataException e) {
			return new ResponseEntity<Error>(new Error(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), "Bad Request", e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			return new ResponseEntity<Error>(new Error(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), "Not Found", e.getMessage()), HttpStatus.NOT_FOUND);
		}catch (Exception e) {
			return new ResponseEntity<Error>(new Error(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error", e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	

}

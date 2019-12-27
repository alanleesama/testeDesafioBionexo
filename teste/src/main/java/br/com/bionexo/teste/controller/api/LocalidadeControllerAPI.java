package br.com.bionexo.teste.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.bionexo.teste.model.LocalidadeResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface LocalidadeControllerAPI {
	
	@ApiOperation("Consulta de UBS próximas")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Ok", response = LocalidadeResponse.class),
			@ApiResponse(code = 400, message = "Bad Request", response = Error.class),
			@ApiResponse(code = 404, message = "Not Found", response = Error.class),
			@ApiResponse(code = 500, message = "Server Error", response = Error.class)
	})
	@GetMapping("/find_ubs/{query}/{page}/{per_page}")
	ResponseEntity<?> obterUbsPróximas(@PathVariable("query") String query, @PathVariable("page") Integer page, @PathVariable("per_page") Integer per_page );

}

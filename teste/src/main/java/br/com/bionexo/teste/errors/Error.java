package br.com.bionexo.teste.errors;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@ApiModel(value = "Error", description = "Modelo de resposta do erro")
@Data
@AllArgsConstructor
public class Error {
	
	@ApiModelProperty(position = 1,  example = "2019-12-26 15:00:00")
	private LocalDateTime timestamp;
	
	@ApiModelProperty(position = 2,  example = "500")
	private Integer status;
	
	@ApiModelProperty(position = 3, example = "Bad Request")
	private String error;
	
	@ApiModelProperty(position = 4, example = "Não foi encontrado nenhuma UBS próxima a você")
	private String message;

}

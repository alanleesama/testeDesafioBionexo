package br.com.bionexo.teste.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "Geocode", description = "Objeto de dados que contém as coordenadas de uma localização")
@Data
public class Geocode implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Double lat;
	
	@JsonProperty("long")
	private Double longitude;

}

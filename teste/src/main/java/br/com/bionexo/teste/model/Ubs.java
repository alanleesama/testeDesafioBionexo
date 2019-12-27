package br.com.bionexo.teste.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Ubs", description = "Objeto de dados que contém os dados de uma UBS")
@Data
public class Ubs implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1,  example = "1")
	private Long id;
	
	@ApiModelProperty(position = 2,  example = "Hospital Albert Einstein")
	private String name;
	
	@ApiModelProperty(position = 3,  example = "Avenida Paulista, 1230")
	private String address;
	
	@ApiModelProperty(position = 4,  example = "Osasco")
	private String city;
	
	@ApiModelProperty(position = 5,  example = "21511233")
	private Long phone;
	
	@ApiModelProperty(position = 6)
	private Geocode geocode;
	
	@ApiModelProperty(position = 7)
	private Score scores;

}

package br.com.bionexo.teste.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@ApiModel(value = "Score", description = "Objeto de dados que contém a pontuação de uma UBS")
@Data
public class Score implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer size;
	
	private Integer adaptation_for_seniors;
	
	private Integer medical_equipment;
	
	private Integer medicine;
	

}

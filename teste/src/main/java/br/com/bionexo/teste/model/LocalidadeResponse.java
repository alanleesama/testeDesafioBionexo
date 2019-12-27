package br.com.bionexo.teste.model;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "LocalidadeResponse", description = "Objeto de dados contendo as ubs")
@Data
public class LocalidadeResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(position = 1,  example = "1")
	private Integer current_page;
	
	@ApiModelProperty(position = 2,  example = "2")
	private Integer per_page;
	
	@ApiModelProperty(position = 3,  example = "45666")
	private Integer total_entries;
	
	@ApiModelProperty(position = 4)
	private List<Ubs> entries;

}

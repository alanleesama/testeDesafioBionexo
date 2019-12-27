package br.com.bionexo.teste.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.bionexo.teste.exceptions.NotFoundException;
import br.com.bionexo.teste.model.LocalidadeResponse;
import br.com.bionexo.teste.model.Ubs;
import br.com.bionexo.teste.utils.FileUtils;
import br.com.bionexo.teste.utils.MathUtils;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class LocalidadeRepository {
	
	private FileUtils fileUtils;
	
	private final Double distanciaPadrao = new Double(10.0);
	
	@Autowired
	public LocalidadeRepository(FileUtils fileUtils) {
		this.fileUtils = fileUtils;
	}
	
	public LocalidadeResponse obterUbsPróximas(Double lat, Double lon, Integer page, Integer per_page) throws NotFoundException {
		
		List<Ubs> arquivo = getListUbs();
		
		LocalidadeResponse response = new LocalidadeResponse();
		
		response.setEntries(new ArrayList<Ubs>());
		
		for(Ubs u : arquivo) {
			Double dist = MathUtils.calculoDistancia(lat, lon, u.getGeocode().getLat(), u.getGeocode().getLongitude());
			if(dist >= distanciaPadrao) {
				response.getEntries().add(u);
			}
		}
		
		if(response.getEntries().isEmpty() ) {
			log.error("Não foram encontradas ubs próximas");
			throw new NotFoundException("Não foram encontradas ubs próximas");
		}
		
		
		return response;
		
	}
	
	public List<Ubs> getListUbs(){
		return fileUtils.loadObjectList(Ubs.class, "data/dados.csv");
	}
	
	

}

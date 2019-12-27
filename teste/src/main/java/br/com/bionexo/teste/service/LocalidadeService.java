package br.com.bionexo.teste.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.bionexo.teste.exceptions.InvalidDataException;
import br.com.bionexo.teste.exceptions.NotFoundException;
import br.com.bionexo.teste.model.LocalidadeResponse;
import br.com.bionexo.teste.repository.LocalidadeRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LocalidadeService {
	
	private LocalidadeRepository repository;
	
	private LocalidadeService(LocalidadeRepository repository) {
		this.repository = repository;
	}
	
	public LocalidadeResponse obterUbsPróximas(String query, Integer page, Integer per_page) throws InvalidDataException, NotFoundException {
		
		if(query.isEmpty() || query == null) {
			log.error("As coordenadas precisam ser preenchidas");
			throw new InvalidDataException("As coordenadas precisam ser preenchidas");
		}
		
		if(page == null || page.intValue() == 0) {
			log.error("Página não informada");
			throw new InvalidDataException("Página não informada");
		}
		
		if(per_page == null || per_page.intValue() == 0) {
			log.error("Número de registros por página não foi informado");
			throw new InvalidDataException("Número de registros por página não foi informado");
		}
		
		String[] latLong = StringUtils.split(query, ",");
		Double lat = new Double(0);
		Double lon = new Double(0);
		try {
			lat = new Double(latLong[0]);
			lon = new Double(latLong[1]);
		}catch(Exception e) {
			log.error("Latitude e/ou longitude estão inválidas");
			throw new InvalidDataException("Latitude e/ou longitude estão inválidas");
		}
		

		
		return repository.obterUbsPróximas(lat, lon, page, per_page);
		
	}

}

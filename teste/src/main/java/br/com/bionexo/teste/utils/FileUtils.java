package br.com.bionexo.teste.utils;

import java.io.File;
import java.util.Collections;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FileUtils {
	
	public <T> List<T> loadObjectList(Class<T> type, String fileName) {
	    try {
	        CsvSchema schema = CsvSchema.emptySchema().withHeader();
	        CsvMapper mapper = new CsvMapper();
	        File file = new ClassPathResource(fileName).getFile();
	        MappingIterator<T> readValues = 
	          mapper.readerFor(type).with(schema).readValues(file);
	        return readValues.readAll();
	    } catch (Exception e) {
	    	log.error("Erro na leitura do arquivo" + fileName, e);
	        return Collections.emptyList();
	    }
	}

}

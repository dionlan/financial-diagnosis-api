package com.mcf.diagnosis.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcf.diagnosis.model.entity.Diagnostic;
import com.mcf.diagnosis.model.entity.dto.DiagnosticDTO;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper ModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Diagnostic.class, DiagnosticDTO.class);
		return modelMapper;
	}
}
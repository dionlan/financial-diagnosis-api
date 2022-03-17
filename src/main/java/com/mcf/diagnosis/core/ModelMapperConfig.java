package com.mcf.diagnosis.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcf.diagnosis.model.entity.Response;
import com.mcf.diagnosis.model.entity.input.ResponseInput;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper ModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Response.class, ResponseInput.class);
		return modelMapper;
	}
}
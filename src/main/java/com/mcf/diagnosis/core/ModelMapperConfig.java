package com.mcf.diagnosis.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcf.diagnosis.model.entity.Answers;
import com.mcf.diagnosis.model.entity.input.AnswersInput;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper ModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Answers.class, AnswersInput.class);
		return modelMapper;
	}
}
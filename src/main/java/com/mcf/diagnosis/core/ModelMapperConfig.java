package com.mcf.diagnosis.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mcf.diagnosis.model.entity.Answer;
import com.mcf.diagnosis.model.entity.input.AnswerInput;

@Configuration
public class ModelMapperConfig {
	
	@Bean
	public ModelMapper ModelMapper() {
		var modelMapper = new ModelMapper();
		modelMapper.createTypeMap(Answer.class, AnswerInput.class);
		return modelMapper;
	}
}
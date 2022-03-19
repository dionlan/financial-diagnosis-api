package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.entity.dto.PersonDto;

/**
 * Ao enviar a requisição, o objeto AnswerInputDoDtoDisassembler é montado para JSON -> DTO -> ENTIDADE (salvo na banco)
 * Na resposta (retorno do método) ResponseOutputToDtoAssembler é desmontado de ENTIDADE -> DTO 
 * 
 *
 */
@Component
public class PersonOutputToDtoAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PersonDto mapEntityDto(Person person) {
		
		return modelMapper.map(person, PersonDto.class);
		
	}
}

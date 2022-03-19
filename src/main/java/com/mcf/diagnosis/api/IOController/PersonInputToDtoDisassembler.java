package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.entity.input.PersonInput;

/**
 * Ao enviar a requisição, o objeto JSON passa para a classe AnswerInputDoDtoDisassembler JSON -> DTO
 * posteriomente o DTO é convertido para Entitydade na classe ResponseOutputToDtoAssembler DTO -> ENTITY
 * na resposta o caminho inverso é seguido.
 * 
 * Entrada das Respostas sendo mapeada para DTO (Model).
 *
 */
@Component
public class PersonInputToDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Person mapToDto(PersonInput personInput) {
		
		return modelMapper.map(personInput, Person.class);
	}
}

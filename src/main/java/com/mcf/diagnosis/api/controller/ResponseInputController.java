package com.mcf.diagnosis.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.IOController.PersonInputToDtoDisassembler;
import com.mcf.diagnosis.api.IOController.PersonOutputToDtoAssembler;
import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.entity.dto.PersonDto;
import com.mcf.diagnosis.model.entity.input.PersonInput;
import com.mcf.diagnosis.model.repository.PersonRepository;

@RestController
@RequestMapping("/api/diagnostico")
public class ResponseInputController {
	
	@Autowired
	private PersonInputToDtoDisassembler responseInputToDtoDisassembler; //entrada das respostas mapeada para DTO para ser salva como entidade
	
	@Autowired
	private PersonOutputToDtoAssembler responseOutputToDtoAssembler; //saída da resposta de entidade modelo e desmontada em DTO.
	
	@Autowired private PersonRepository personRepository;

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonDto salvar(@RequestBody PersonInput personInput) {
		
		Person person = responseInputToDtoDisassembler.mapToDto(personInput);
		
		return responseOutputToDtoAssembler.mapEntityDto(personRepository.save(person));
	}
}
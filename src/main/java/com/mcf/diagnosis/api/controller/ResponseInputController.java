package com.mcf.diagnosis.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.IOController.PersonInputToDtoDisassembler;
import com.mcf.diagnosis.api.IOController.PersonOutputToDtoAssembler;
import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.entity.dto.PersonDto;
import com.mcf.diagnosis.model.entity.input.PersonInput;
import com.mcf.diagnosis.model.exception.PersonNotFoundException;
import com.mcf.diagnosis.model.exception.RegraNegocioException;
import com.mcf.diagnosis.model.service.PersonService;

@RestController
@RequestMapping("/api/diagnostico")
public class ResponseInputController {
	
	@Autowired
	private PersonInputToDtoDisassembler responseInputToDtoDisassembler; //entrada das respostas mapeada para DTO para ser salva como entidade
	
	@Autowired
	private PersonOutputToDtoAssembler responseOutputToDtoAssembler; //saída da resposta de entidade modelo e desmontada em DTO.
	
	@Autowired private PersonService personService;

	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public PersonDto salvar(@RequestBody PersonInput personInput) {
		
		Person person = responseInputToDtoDisassembler.mapToEntity(personInput);
		
		return responseOutputToDtoAssembler.mapEntityDto(personService.salvar(person));
	}
	
	@PutMapping("/{email}")
	public PersonDto buscar(@PathVariable String email, @RequestBody PersonInput personInput) {
		
		try {
			Person person = personService.obterPorEmail(email);
			
			responseInputToDtoDisassembler.mapToEntityUpdate(personInput, person);
			
			return responseOutputToDtoAssembler.mapEntityDto(personService.salvar(person));
			
		}catch(PersonNotFoundException e) {
			throw new RegraNegocioException(e.getMessage());
		}
	}
}
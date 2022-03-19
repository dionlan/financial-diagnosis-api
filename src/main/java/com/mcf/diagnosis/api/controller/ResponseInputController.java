package com.mcf.diagnosis.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.IOController.PersonInputToDtoDisassembler;
import com.mcf.diagnosis.api.IOController.PersonOutputToDtoAssembler;
import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.entity.input.PersonInput;
import com.mcf.diagnosis.model.repository.ItemResponseRepository;
import com.mcf.diagnosis.model.repository.ItemResponsesRepository;
import com.mcf.diagnosis.model.repository.PersonRepository;
import com.mcf.diagnosis.model.repository.ResponseRepository;
import com.mcf.diagnosis.model.service.ResponseService;

@RestController
@RequestMapping("/api/diagnostico")
public class ResponseInputController {
	
	@Autowired
	private PersonInputToDtoDisassembler responseInputToDtoDisassembler; //entrada das respostas mapeada para DTO para ser salva como entidade
	
	@Autowired
	private PersonOutputToDtoAssembler responseOutputToDtoAssembler; //saída da resposta de entidade modelo e desmontada em DTO.
	
	@Autowired
	private ResponseService service;
	@Autowired private ResponseRepository responseRepository;
	@Autowired private PersonRepository personRepository;
	@Autowired private ItemResponseRepository itemResponseRepository;
	@Autowired private ItemResponsesRepository itemResponsesRepository;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> salvar(@RequestBody PersonInput personInput) {
		
		Person person = responseInputToDtoDisassembler.mapToDto(personInput);

		personRepository.save(person);
		//service.salvar(response);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
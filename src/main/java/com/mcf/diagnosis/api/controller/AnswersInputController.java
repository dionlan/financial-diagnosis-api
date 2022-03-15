package com.mcf.diagnosis.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.mcf.diagnosis.api.IOController.AnswerOutputToDtoAssembler;
import com.mcf.diagnosis.api.IOController.AnswersInputToDtoDisassembler;
import com.mcf.diagnosis.model.entity.Answers;
import com.mcf.diagnosis.model.entity.dto.AnswersDto;
import com.mcf.diagnosis.model.entity.input.AnswersInput;
import com.mcf.diagnosis.model.service.AnswersService;

@RestController
@RequestMapping("/api/diagnostico")
public class AnswersInputController {
	
	@Autowired
	private AnswersInputToDtoDisassembler answersInputToDtoDisassembler; //entrada das respostas mapeada para DTO para ser salva como entidade
	
	@Autowired
	private AnswerOutputToDtoAssembler answerOutputToDtoAssembler; //saída da resposta de entidade modelo e desmontada em DTO.
	
	@Autowired
	private AnswersService service;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public AnswersDto salvar(@RequestBody AnswersInput answersInput) throws JsonMappingException, JsonProcessingException {
		
		//ObjectMapper mapper = new ObjectMapper();
		//AnswersInput diagnosticInput = mapper.readValue(respostas, AnswersInput.class);
		
		Answers answers = answersInputToDtoDisassembler.mapToDto(answersInput);
		
		return answerOutputToDtoAssembler.mapEntityDto(service.salvar(answers));
	}
}
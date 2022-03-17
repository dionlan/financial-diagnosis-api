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
import com.mcf.diagnosis.api.IOController.AnswerInputToDtoDisassembler;
import com.mcf.diagnosis.model.entity.Answer;
import com.mcf.diagnosis.model.entity.dto.AnswerDto;
import com.mcf.diagnosis.model.entity.input.AnswerInput;
import com.mcf.diagnosis.model.service.AnswerService;

@RestController
@RequestMapping("/api/diagnostico")
public class AnswerInputController {
	
	@Autowired
	private AnswerInputToDtoDisassembler answerInputToDtoDisassembler; //entrada das respostas mapeada para DTO para ser salva como entidade
	
	@Autowired
	private AnswerOutputToDtoAssembler answerOutputToDtoAssembler; //saída da resposta de entidade modelo e desmontada em DTO.
	
	@Autowired
	private AnswerService service;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public AnswerDto salvar(@RequestBody AnswerInput answerInput) throws JsonMappingException, JsonProcessingException {
		
		Answer answer = answerInputToDtoDisassembler.mapToDto(answerInput);
		
		return answerOutputToDtoAssembler.mapEntityDto(service.salvar(answer));
	}
}
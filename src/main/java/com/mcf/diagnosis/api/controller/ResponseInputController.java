package com.mcf.diagnosis.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.IOController.ResponseInputToDtoDisassembler;
import com.mcf.diagnosis.api.IOController.ResponseOutputToDtoAssembler;
import com.mcf.diagnosis.model.entity.Response;
import com.mcf.diagnosis.model.entity.dto.ResponseDto;
import com.mcf.diagnosis.model.entity.input.ResponseInput;
import com.mcf.diagnosis.model.service.ResponseService;

@RestController
@RequestMapping("/api/diagnostico")
public class ResponseInputController {
	
	@Autowired
	private ResponseInputToDtoDisassembler responseInputToDtoDisassembler; //entrada das respostas mapeada para DTO para ser salva como entidade
	
	@Autowired
	private ResponseOutputToDtoAssembler responseOutputToDtoAssembler; //saída da resposta de entidade modelo e desmontada em DTO.
	
	@Autowired
	private ResponseService service;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseDto salvar(@RequestBody ResponseInput responseInput) {
		
		Response response = responseInputToDtoDisassembler.mapToDto(responseInput);
		
		return responseOutputToDtoAssembler.mapEntityDto(service.salvar(response));
	}
}
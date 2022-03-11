package com.mcf.diagnosis.api.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mcf.diagnosis.api.IOController.DiagnosticInputController;
import com.mcf.diagnosis.api.IOController.DiagnosticOutputController;
import com.mcf.diagnosis.api.IOController.ObjectMapperUtils;
import com.mcf.diagnosis.model.entity.Diagnostic;
import com.mcf.diagnosis.model.entity.dto.DiagnosticDTO;
import com.mcf.diagnosis.model.entity.dto.input.DiagnosticInput;
import com.mcf.diagnosis.model.service.DiagnosticService;

@RestController
@RequestMapping("/api/diagnostico")
public class DiagnosticController {
	
	@Autowired
	private DiagnosticInputController diagnosticInputController;
	
	@Autowired
	private DiagnosticOutputController diagnosticOutputController;
	
	@Autowired
	private DiagnosticService service;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public DiagnosticDTO salvar(@RequestBody String respostas) throws JsonMappingException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		DiagnosticInput diagnosticInput = mapper.readValue(respostas, DiagnosticInput.class);
		
		Diagnostic diagnostic = diagnosticInputController.mapToEntity(diagnosticInput);
		return diagnosticOutputController.mapToDto(service.salvar(diagnostic));
	}
}
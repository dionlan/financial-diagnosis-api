package com.mcf.diagnosis.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.IOController.DiagnosticInputController;
import com.mcf.diagnosis.api.IOController.DiagnosticOutputController;
import com.mcf.diagnosis.model.entity.Diagnostic;
import com.mcf.diagnosis.model.entity.dto.DiagnosticDTO;
import com.mcf.diagnosis.model.entity.dto.input.DiagnosticInput;
import com.mcf.diagnosis.model.service.DiagnosticService;

@RestController
@RequestMapping("/api/pessoa")
public class PersonController {
	
	@Autowired
	private DiagnosticInputController diagnosticInputController;
	
	@Autowired
	private DiagnosticOutputController diagnosticOutputController;
	
	@Autowired
	private DiagnosticService service;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public DiagnosticDTO salvar(@RequestBody @Valid DiagnosticInput diagnosticInput) {
		
		Diagnostic diagnostic = diagnosticInputController.mapToEntity(diagnosticInput);
		return diagnosticOutputController.mapToDto(service.salvar(diagnostic));
	}
}
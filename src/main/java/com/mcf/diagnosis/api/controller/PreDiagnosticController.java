package com.mcf.diagnosis.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.IOController.PreDiagnosticOutputToDtoAssembler;
import com.mcf.diagnosis.model.entity.PreDiagnostic;
import com.mcf.diagnosis.model.entity.dto.PreDiagnosticDto;
import com.mcf.diagnosis.model.service.PreDiagnosticService;

@RestController
@RequestMapping("/api/pre-diagnostico")
public class PreDiagnosticController {
	
	@Autowired
	private PreDiagnosticService preDiagnosticService;
	
	@Autowired
	private PreDiagnosticOutputToDtoAssembler preDiagnosticOutputToDtoAssembler;
	
	@GetMapping("/{email}")
	public PreDiagnosticDto buscarResultadoPrevio(@PathVariable String email) {
		PreDiagnostic preDiagnostic = preDiagnosticService.buscarResultadoPrevio(email);
		
		return preDiagnosticOutputToDtoAssembler.mapEntityDto(preDiagnostic);
	}
}
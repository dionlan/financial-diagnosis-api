package com.mcf.diagnosis.api.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.IOController.PreDiagnosticInputToDtoDisassembler;
import com.mcf.diagnosis.api.IOController.PreDiagnosticOutputToDtoAssembler;
import com.mcf.diagnosis.model.entity.PreDiagnostic;
import com.mcf.diagnosis.model.entity.dto.PreDiagnosticDto;
import com.mcf.diagnosis.model.entity.input.PreDiagnosticInput;
import com.mcf.diagnosis.model.service.PreDiagnosticService;

@RestController
@RequestMapping("/api/previadiagnostico")
public class PreDiagnosticController {
	
	@Autowired
	private PreDiagnosticService preDiagnosticService;
	
	@Autowired
	private	PreDiagnosticInputToDtoDisassembler preDiagnosticInputToDtoDisassembler;
	
	@Autowired
	private PreDiagnosticOutputToDtoAssembler preDiagnosticOutputToDtoAssembler;
	
	@PostMapping("/salvar")
	@ResponseStatus(HttpStatus.CREATED)
	public PreDiagnosticDto salvar(@RequestBody PreDiagnosticInput preDiagnosticInput) {
		
		PreDiagnostic preDiagnostic = preDiagnosticInputToDtoDisassembler.mapToEntity(preDiagnosticInput);
		BigDecimal notaFinal = preDiagnosticService.obterNotaFinal(preDiagnosticInput.getPersonId());
		preDiagnostic.setFinalNote(notaFinal);
		return preDiagnosticOutputToDtoAssembler.mapEntityDto(preDiagnosticService.salvar(preDiagnostic));
	}
	
	@GetMapping("/{email}")
	public PreDiagnosticDto buscarResultadoPrevio(@RequestBody Long id) {
		PreDiagnostic preDiagnostic = preDiagnosticService.buscarPreDiagnostic(id);
		
		return preDiagnosticOutputToDtoAssembler.mapEntityDto(preDiagnostic);
	}
}
package com.mcf.diagnosis.api.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.mcf.diagnosis.model.enums.Classification;
import com.mcf.diagnosis.model.service.PreDiagnosticService;

@RestController
@RequestMapping("/api/previa-diagnostico")
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
		if(notaFinal.compareTo(new BigDecimal(10)) < 0) {
			preDiagnostic.setClassification(Classification.RISCO);
		}else if (notaFinal.compareTo(new BigDecimal(10)) > 0 && notaFinal.compareTo(new BigDecimal(50)) < 0) {
			preDiagnostic.setClassification(Classification.MEDIANO);
		}else if (notaFinal.compareTo(new BigDecimal(50)) > 0) {
			preDiagnostic.setClassification(Classification.BEM_ESTAR_FINANCEIRO);
		}
		return preDiagnosticOutputToDtoAssembler.mapEntityDto(preDiagnosticService.salvar(preDiagnostic));
	}
	
	@GetMapping("/{id}")
	public PreDiagnosticDto buscarResultadoPrevio(@PathVariable Long id) {
		PreDiagnostic preDiagnostic = preDiagnosticService.buscarPreDiagnostico(id);
		
		return preDiagnosticOutputToDtoAssembler.mapEntityDto(preDiagnostic);
	}
}
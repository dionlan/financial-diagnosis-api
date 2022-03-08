package com.mcf.diagnosis.api.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcf.diagnosis.api.input.DiagnosticInput;
import com.mcf.diagnosis.model.entity.dto.DiagnosticDTO;

@RestController
@RequestMapping("/api/diagnostico")
public class QuestionnaireController {
	
	public DiagnosticDTO salvar(@RequestBody @Valid DiagnosticInput diagnosticInput) {
		return null;
	}
}
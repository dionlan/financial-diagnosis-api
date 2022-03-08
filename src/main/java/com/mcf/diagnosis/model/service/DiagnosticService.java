package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mcf.diagnosis.model.entity.Diagnostic;
import com.mcf.diagnosis.model.repository.DiagnosticRepository;

@Service
public class DiagnosticService {

	@Autowired
	private DiagnosticRepository repository;

	public Diagnostic salvar(Diagnostic diagnostic) {
	
		return repository.save(diagnostic);
	}
}

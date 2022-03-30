package com.mcf.diagnosis.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcf.diagnosis.model.entity.PreDiagnostic;
import com.mcf.diagnosis.model.repository.PreDiagnosticRepository;

@Service
public class PreDiagnosticService {

	@Autowired
	private PreDiagnosticRepository preDiagnosticRepository;

	@Transactional(readOnly = true)
	public PreDiagnostic buscarResultadoPrevio(String email) {
		
		return preDiagnosticRepository.buscarResultadoPrevio(email);
	}
}

package com.mcf.diagnosis.model.service;

import java.math.BigDecimal;

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
	public BigDecimal obterNotaFinal(Long personId) {
		BigDecimal notaFinal = preDiagnosticRepository.obterFinalNote(personId);
		return notaFinal;
	}
	
	@Transactional
	public PreDiagnostic salvar(PreDiagnostic preDiagnostic) {
		return preDiagnosticRepository.save(preDiagnostic);
	}
	
	@Transactional
	public PreDiagnostic buscarPreDiagnostic(Long id) {
		return preDiagnosticRepository.getById(id);
	}
}

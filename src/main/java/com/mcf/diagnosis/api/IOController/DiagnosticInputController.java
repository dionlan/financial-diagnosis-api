package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Diagnostic;
import com.mcf.diagnosis.model.entity.dto.input.DiagnosticInput;

/**
 * Classe que realiza a "desmontagem"/disassembler/parse da instancia do objeto json da classe DiagnosticInput para a Entidade Diagnostic
 * @author dius_
 *
 */
@Component
public class DiagnosticInputController {

	@Autowired
	private ModelMapper modelMapper;
	
	public Diagnostic mapToEntity(DiagnosticInput diagnosticInput) {
		return modelMapper.map(diagnosticInput, Diagnostic.class);
	}
}

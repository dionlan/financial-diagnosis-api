package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.PreDiagnostic;
import com.mcf.diagnosis.model.entity.input.PreDiagnosticInput;

@Component
public class PreDiagnosticInputToDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public PreDiagnostic mapToEntity(PreDiagnosticInput preDiagnosticInput) {
		
		return modelMapper.map(preDiagnosticInput, PreDiagnostic.class);
	}
	
	public void mapToEntityUpdate(PreDiagnosticInput preDiagnosticInput, PreDiagnostic preDiagnostic) {
		modelMapper.map(preDiagnosticInput, preDiagnostic);
	}
}

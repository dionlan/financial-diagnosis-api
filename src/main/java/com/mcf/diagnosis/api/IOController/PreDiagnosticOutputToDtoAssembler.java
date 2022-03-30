package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.PreDiagnostic;
import com.mcf.diagnosis.model.entity.dto.PreDiagnosticDto;

@Component
public class PreDiagnosticOutputToDtoAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public PreDiagnosticDto mapEntityDto(PreDiagnostic preDiagnostic) {
		
		return modelMapper.map(preDiagnostic, PreDiagnosticDto.class);
	}
}

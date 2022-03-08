package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Diagnostic;
import com.mcf.diagnosis.model.entity.dto.DiagnosticDTO;

/**
 * Classe que monta o objeto do tipo entidade para o tipo DTO (json)
 * @author dius_
 *
 */
@Component
public class DiagnosticOutputController {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public DiagnosticDTO mapToDto(Diagnostic diagnostic) {
		return modelMapper.map(diagnostic, DiagnosticDTO.class);
	}
}

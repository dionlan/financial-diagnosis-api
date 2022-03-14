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
	
	public Diagnostic mapToEntity(DiagnosticDTO diagnosticDTO) {
		/*modelMapper.typeMap(DiagnosticDTO.class, Diagnostic.class).addMapping(DiagnosticDTO::getAnswer, Diagnostic::setAnswer);
		
		TypeMap<DiagnosticDTO, Diagnostic> tm = modelMapper.getTypeMap(DiagnosticDTO.class, Diagnostic.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list)
	    {
	        System.out.println(m);
	    }*/
		
		return modelMapper.map(diagnosticDTO, Diagnostic.class);
	}
}

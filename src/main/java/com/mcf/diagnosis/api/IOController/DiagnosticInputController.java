package com.mcf.diagnosis.api.IOController;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.modelmapper.spi.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Diagnostic;
import com.mcf.diagnosis.model.entity.dto.DiagnosticDTO;
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
	
	public DiagnosticDTO mapToDTO(DiagnosticInput diagnosticInput) {
		modelMapper.typeMap(DiagnosticInput.class, DiagnosticDTO.class).addMapping(DiagnosticInput::getAnswer, DiagnosticDTO::setAnswer);
		
		TypeMap<DiagnosticInput, DiagnosticDTO> tm = modelMapper.getTypeMap(DiagnosticInput.class, DiagnosticDTO.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list)
	    {
	        System.out.println(m);
	    }
		
		
		return modelMapper.map(diagnosticInput, DiagnosticDTO.class);
	}
	
	public DiagnosticDTO mapEntityDTO(Diagnostic diagnostic) {
		return modelMapper.map(diagnostic, DiagnosticDTO.class);
	}
}

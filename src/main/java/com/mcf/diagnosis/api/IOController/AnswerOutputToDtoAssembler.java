package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Answer;
import com.mcf.diagnosis.model.entity.dto.AnswerDto;

/**
 * Ao enviar a requisição, o objeto AnswerInputDoDtoDisassembler é montado para JSON -> DTO -> ENTIDADE (salvo na banco)
 * Na resposta (retorno do método) AnswerOutputToDtoAssembler é desmontado de ENTIDADE -> DTO 
 * 
 *
 */
@Component
public class AnswerOutputToDtoAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public AnswerDto mapEntityDto(Answer answer) {
		/*modelMapper.typeMap(DiagnosticDTO.class, Diagnostic.class).addMapping(DiagnosticDTO::getAnswer, Diagnostic::setAnswer);
		
		TypeMap<DiagnosticDTO, Diagnostic> tm = modelMapper.getTypeMap(DiagnosticDTO.class, Diagnostic.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list)
	    {
	        System.out.println(m);
	    }*/
		
		return modelMapper.map(answer, AnswerDto.class);
		
	}
}

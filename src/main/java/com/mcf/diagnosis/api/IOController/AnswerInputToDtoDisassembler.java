package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Answer;
import com.mcf.diagnosis.model.entity.input.AnswerInput;

/**
 * Ao enviar a requisição, o objeto JSON passa para a classe AnswerInputDoDtoDisassembler JSON -> DTO
 * posteriomente o DTO é convertido para Entitydade na classe AnswerOutputToDtoAssembler DTO -> ENTITY
 * na resposta o caminho inverso é seguido.
 * 
 * Entrada das Respostas sendo mapeada para DTO (Model).
 *
 */
@Component
public class AnswerInputToDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Answer mapToDto(AnswerInput answerInput) {
		/*modelMapper.typeMap(AnswerInput.class, DiagnosticDTO.class).addMapping(AnswerInput::getAnswer, DiagnosticDTO::setAnswer);
		
		TypeMap<AnswerInput, DiagnosticDTO> tm = modelMapper.getTypeMap(AnswerInput.class, DiagnosticDTO.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list)
	    {
	        System.out.println(m);
	    }*/
		
		return modelMapper.map(answerInput, Answer.class);
	}
}

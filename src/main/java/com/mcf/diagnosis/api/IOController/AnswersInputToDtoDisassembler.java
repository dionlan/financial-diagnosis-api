package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Answers;
import com.mcf.diagnosis.model.entity.input.AnswersInput;

/**
 * Ao enviar a requisição, o objeto JSON passa para a classe AnswerInputDoDtoDisassembler JSON -> DTO
 * posteriomente o DTO é convertido para Entitydade na classe AnswerOutputToDtoAssembler DTO -> ENTITY
 * na resposta o caminho inverso é seguido.
 * 
 * Entrada das Respostas sendo mapeada para DTO (Model).
 *
 */
@Component
public class AnswersInputToDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Answers mapToDto(AnswersInput answersInput) {
		/*modelMapper.typeMap(AnswersInput.class, DiagnosticDTO.class).addMapping(AnswersInput::getAnswer, DiagnosticDTO::setAnswer);
		
		TypeMap<AnswersInput, DiagnosticDTO> tm = modelMapper.getTypeMap(AnswersInput.class, DiagnosticDTO.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list)
	    {
	        System.out.println(m);
	    }*/
		
		return modelMapper.map(answersInput, Answers.class);
	}
}

package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Response;
import com.mcf.diagnosis.model.entity.input.ResponseInput;

/**
 * Ao enviar a requisição, o objeto JSON passa para a classe AnswerInputDoDtoDisassembler JSON -> DTO
 * posteriomente o DTO é convertido para Entitydade na classe ResponseOutputToDtoAssembler DTO -> ENTITY
 * na resposta o caminho inverso é seguido.
 * 
 * Entrada das Respostas sendo mapeada para DTO (Model).
 *
 */
@Component
public class ResponseInputToDtoDisassembler {

	@Autowired
	private ModelMapper modelMapper;
	
	public Response mapToDto(ResponseInput responseInput) {
		/*modelMapper.typeMap(ResponseInput.class, DiagnosticDTO.class).addMapping(ResponseInput::getAnswer, DiagnosticDTO::setAnswer);
		
		TypeMap<ResponseInput, DiagnosticDTO> tm = modelMapper.getTypeMap(ResponseInput.class, DiagnosticDTO.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list)
	    {
	        System.out.println(m);
	    }*/
		
		return modelMapper.map(responseInput, Response.class);
	}
}

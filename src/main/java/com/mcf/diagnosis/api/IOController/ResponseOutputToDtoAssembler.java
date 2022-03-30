package com.mcf.diagnosis.api.IOController;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcf.diagnosis.model.entity.Response;
import com.mcf.diagnosis.model.entity.dto.ResponseDto;

/**
 * Ao enviar a requisição, o objeto AnswerInputDoDtoDisassembler é montado para JSON -> DTO -> ENTIDADE (salvo na banco)
 * Na resposta (retorno do método) ResponseOutputToDtoAssembler é desmontado de ENTIDADE -> DTO 
 * 
 *
 */
@Component
public class ResponseOutputToDtoAssembler {
	
	@Autowired
	private ModelMapper modelMapper;
	
	public ResponseDto mapEntityDto(Response response) {
		/*modelMapper.typeMap(DiagnosticDTO.class, PreDiagnosticDto.class).addMapping(DiagnosticDTO::getAnswer, PreDiagnosticDto::setAnswer);
		
		TypeMap<DiagnosticDTO, PreDiagnosticDto> tm = modelMapper.getTypeMap(DiagnosticDTO.class, PreDiagnosticDto.class);
	    List<Mapping> list = tm.getMappings();
	    for (Mapping m : list)
	    {
	        System.out.println(m);
	    }*/
		
		return modelMapper.map(response, ResponseDto.class);
		
	}
}

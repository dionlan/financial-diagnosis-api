package com.mcf.diagnosis.model.entity.dto.input;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.mcf.diagnosis.model.entity.Answer;
import com.mcf.diagnosis.model.entity.Person;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiagnosticInput {

	/*
	 * 
	 * primeiro caso feliz a ser criado: respostas com apenas o id da resposta. 
	 * segundo caso: com a resposta contendo uma lista de outras respostas = objetivos financeiros imediatos
	 */
	/**/
	@Valid
	@NotNull
	private Person person; 

	private List<Answer> answers;
	
}

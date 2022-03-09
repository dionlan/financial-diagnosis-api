package com.mcf.diagnosis.model.entity.dto.input;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerReferenceInput {

	@Valid
	private DiagnosticIdInput diagnostic;
	
	@Valid
	private PersonIdInput person;
	
	@Valid
	private List<ItemReferenceInput> respostas = new ArrayList<>();
}

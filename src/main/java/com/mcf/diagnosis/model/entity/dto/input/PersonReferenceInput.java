package com.mcf.diagnosis.model.entity.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonReferenceInput {
	
	@Valid
	private DiagnosticIdInput id;

	@NotNull
	private String name;
	
	@NotNull
	private String email;
}

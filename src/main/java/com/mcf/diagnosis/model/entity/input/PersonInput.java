package com.mcf.diagnosis.model.entity.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonInput {
	
	@Valid
	@NotNull
	private String name;
	
	@Valid
	@NotNull
	private String email;
}
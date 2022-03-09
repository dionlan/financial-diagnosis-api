package com.mcf.diagnosis.model.entity.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonDTO {

	private Long id;
	
	@NotNull
	@Valid
	private String name;
	
	@NotNull
	@Valid
	private String email;
}

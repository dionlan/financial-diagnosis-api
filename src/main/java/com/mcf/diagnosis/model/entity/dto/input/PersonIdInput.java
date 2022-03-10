package com.mcf.diagnosis.model.entity.dto.input;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonIdInput {

	@Valid
	@NotNull
	private Long id;
}

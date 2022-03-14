package com.mcf.diagnosis.model.entity.dto.input;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemInput {
	
	@NotNull
	private Long codigo;
	
	@NotNull
	private String description;

}

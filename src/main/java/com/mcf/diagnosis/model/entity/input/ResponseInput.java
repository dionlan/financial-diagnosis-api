package com.mcf.diagnosis.model.entity.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseInput {
	
	@NotNull
	private PersonInput person; 

	private List<ItemResponseInput> responses;
	
}

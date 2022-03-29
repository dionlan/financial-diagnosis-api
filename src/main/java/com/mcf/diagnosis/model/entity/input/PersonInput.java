package com.mcf.diagnosis.model.entity.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class PersonInput {
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	private List<ItemResponseInput> responses;
}

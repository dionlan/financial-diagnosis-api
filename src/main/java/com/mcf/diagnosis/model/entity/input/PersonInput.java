package com.mcf.diagnosis.model.entity.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonInput {
	
	@NotNull
	private String name;
	
	@NotNull
	private Integer age;
	
	@NotNull
	private String email;
	
	@NotNull
	private String phone;
	
	private List<ItemResponseInput> responses;
}

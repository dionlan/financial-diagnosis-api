package com.mcf.diagnosis.model.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(Include.NON_NULL)
public class PersonDto {

	private Long id;
	
	@NotNull
	@Valid
	private String name;
	
	@NotNull
	private String age;
	
	@NotNull
	@Valid
	private String email;
	
	@NotNull
	@Valid
	private String phone;
	
	@NotNull
	@Valid
	private List<ItemResponseDto> responses = new ArrayList<>();
}
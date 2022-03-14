package com.mcf.diagnosis.model.entity.dto.input;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswerInput {
	
	@NotNull
	private Set<ItemInput> respostas = new HashSet<>();
}

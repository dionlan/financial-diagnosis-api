package com.mcf.diagnosis.model.entity.input;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswersInput {
	
	@NotNull
	private PersonInput person; 

	@NotNull
	private Set<ItemInput> answers = new HashSet<>();

	//private FinancialAnswersInputDto_old answer;
	
}

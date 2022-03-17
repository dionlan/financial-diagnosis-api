package com.mcf.diagnosis.model.entity.input;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AnswerInput {
	
	@NotNull
	private PersonInput person; 

	private List<ItemInput> answers;

	//private FinancialAnswersInputDto_old answer;
	
}

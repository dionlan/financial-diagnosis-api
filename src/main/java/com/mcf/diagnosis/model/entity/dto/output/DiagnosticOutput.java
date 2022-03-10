package com.mcf.diagnosis.model.entity.dto.output;

import java.math.BigDecimal;
import java.util.List;

import com.mcf.diagnosis.model.entity.Answer;
import com.mcf.diagnosis.model.entity.Person;
import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiagnosticOutput {
	
	private Long id;
	
	private Person person;
	
	private List<Answer> answer;
	
	private BigDecimal finalNote;
	
	private Classification classification;

}

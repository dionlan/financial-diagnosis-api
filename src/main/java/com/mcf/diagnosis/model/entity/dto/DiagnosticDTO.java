package com.mcf.diagnosis.model.entity.dto;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.mcf.diagnosis.model.entity.Question;
import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DiagnosticDTO {

	private Long id;
	
	private PersonDTO person;
	
	private ArrayList<Question> diagnostic = new ArrayList<>();
	
	private BigDecimal finalNote;
	
	private Classification classification;
}

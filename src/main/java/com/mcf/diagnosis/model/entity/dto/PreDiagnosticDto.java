package com.mcf.diagnosis.model.entity.dto;

import java.math.BigDecimal;

import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PreDiagnosticDto {
	
	private PersonDto person; 

	private BigDecimal finalNote;
	
	private Classification classification;
}
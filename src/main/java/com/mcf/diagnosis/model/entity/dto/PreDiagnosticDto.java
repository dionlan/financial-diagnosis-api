package com.mcf.diagnosis.model.entity.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PreDiagnosticDto {
	
	private PersonDto person; 

	private BigDecimal finalNote;
	
	private String classification;
}
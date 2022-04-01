package com.mcf.diagnosis.model.entity.input;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PreDiagnosticInput {
	
	@JsonProperty(value = "id")
	private Long personId;
	
	private BigDecimal finalNote;
	
	private Classification classification;
}

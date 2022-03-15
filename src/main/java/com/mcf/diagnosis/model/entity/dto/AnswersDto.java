package com.mcf.diagnosis.model.entity.dto;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnswersDto {

	private Long id;
	
	private PersonDto person;
	
	private Set<ItemDto> answers = new HashSet<>();
	
	private BigDecimal notaFinal;
	
	private Classification classificacao;
}
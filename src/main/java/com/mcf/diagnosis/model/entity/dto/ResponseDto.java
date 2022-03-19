package com.mcf.diagnosis.model.entity.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.mcf.diagnosis.model.enums.Classification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto {

	private Long id;

	private PersonDto person; 
	
	private List<ItemResponseDto> responses = new ArrayList<>();

	private BigDecimal notaFinal;
	
	private Classification classificacao;


}